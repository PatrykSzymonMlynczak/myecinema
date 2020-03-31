package com.wikingowie.myecinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wikingowie.myecinema.entities.Seance;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
