package com.wikingowie.myecinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wikingowie.myecinema.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
