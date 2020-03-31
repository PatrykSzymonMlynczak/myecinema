package com.wikingowie.myecinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wikingowie.myecinema.entities.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
}
