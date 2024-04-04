package com.movie.entites;


import jakarta.persistence.*;
import lombok.*;


import java.time.*;
import java.util.*;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ticketId_generator")
    @SequenceGenerator(name="ticketId_generator", sequenceName = "ticket_id_seq", initialValue = 1023984)
    private long ticketId;
    @ManyToOne
    private Users userId;
    private String movieName;
    private String movieTheaterName;
    private LocalDate showDate;
    private LocalTime showTime;
    private List<String> bookedSeats;
    private LocalTime bookedTime;

}
