package com.movie.response;


import com.movie.entites.*;
import lombok.*;

import java.time.*;
import java.util.*;


@Data
public class TicketRequest {


    private String movieName;
    private String movieTheaterName;
    private LocalDate showDate;
    private LocalTime showTime;

    private List<Seat> bookedSeats;



}
