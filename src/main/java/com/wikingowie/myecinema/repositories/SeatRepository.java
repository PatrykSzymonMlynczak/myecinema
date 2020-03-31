package com.wikingowie.myecinema.repositories;

import com.wikingowie.myecinema.entities.ExampleEntity;
import com.wikingowie.myecinema.entities.Seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
