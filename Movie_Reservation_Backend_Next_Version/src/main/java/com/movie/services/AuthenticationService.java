package com.movie.services;

import com.movie.utility.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.movie.response.AuthenticationResponse;
import com.movie.entites.Users;
import com.movie.excpetion.UserEmailIdExistsException;
import com.movie.excpetion.UserNotFoundException;
import com.movie.repositories.UsersRepository;

@Service
public class AuthenticationService {

    private final UsersRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationService(UsersRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
                                 AuthenticationManager authenticationManager) {
        super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse register(Users request) throws UserEmailIdExistsException {
        Users user = new Users();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUserName(request.getEmailId());
        user.setEmailId(request.getEmailId());
        user.setMobileNo(request.getMobileNo());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(request.getRole());
        if (userRepository.findByEmailId(request.getEmailId()).isEmpty()) {

            user = userRepository.save(user);

            String token = jwtService.generateToken(user);
            if(user.getRole() == Role.USER)
              CustomerProfileSessionService.setCustomerData(user);
            else
              AdminProfileSessionService.setAdminData(user);


            return new AuthenticationResponse(user, token);
        } else {
            throw new UserEmailIdExistsException("Given email id exists");
        }

    }

    public AuthenticationResponse authenticate(Users request) throws Exception {
        Users user = userRepository.findByEmailId(request.getEmailId()).orElseThrow(() -> new UserNotFoundException("Given email not exist"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmailId(),
                        request.getPassword()
                )

        );


        String token = jwtService.generateToken(user);

        if(user.getRole() == Role.USER)
            CustomerProfileSessionService.setCustomerData(user);
        else
            AdminProfileSessionService.setAdminData(user);
        System.out.println("Getting Customer Data");
     System.out.println(CustomerProfileSessionService.getCustomerData());
        return new AuthenticationResponse(user, token);

    }


}
