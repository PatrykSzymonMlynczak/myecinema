package com.wikingowie.myecinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wikingowie.myecinema.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
