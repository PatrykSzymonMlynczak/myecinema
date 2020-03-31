package com.wikingowie.myecinema.repositories;

import com.wikingowie.myecinema.entities.ExampleEntity;
import com.wikingowie.myecinema.entities.Seance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
