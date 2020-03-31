package com.wikingowie.myecinema.repositories;

import com.wikingowie.myecinema.entities.Booking;
import com.wikingowie.myecinema.entities.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
