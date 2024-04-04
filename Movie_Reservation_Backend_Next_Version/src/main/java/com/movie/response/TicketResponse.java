package com.movie.response;


import com.movie.entites.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.time.format.*;
import java.util.*;


@Data
public class TicketResponse {

    private long ticketId;
    private UsersResponse user;

    private String movieName;
    private String movieTheaterName;
    private LocalDate showDate;
    private LocalTime showTime;

    private List<String> bookedSeats;

     @Transient
    private String formatDate;

    public void setFormattedShowDate() {
        // Define the pattern for the formatted date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM", Locale.ENGLISH);
        // Format the showDate using the defined pattern
        this.formatDate =  showDate.format(formatter);
    }


}
