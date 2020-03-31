package com.wikingowie.myecinema.repositories;

import com.wikingowie.myecinema.entities.ExampleEntity;
import com.wikingowie.myecinema.entities.Hall;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
}
