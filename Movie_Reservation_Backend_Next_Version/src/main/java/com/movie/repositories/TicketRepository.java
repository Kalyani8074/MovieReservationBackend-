package com.movie.repositories;

import com.movie.entites.*;
import org.springframework.data.jpa.repository.*;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
