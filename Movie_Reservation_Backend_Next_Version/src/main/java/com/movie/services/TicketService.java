package com.movie.services;

import com.movie.entites.*;
import com.movie.iservices.*;
import com.movie.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public Ticket createTicket(Ticket ticket) {
         return ticketRepository.save(ticket);
    }
}
