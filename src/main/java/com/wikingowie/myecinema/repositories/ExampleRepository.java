package com.wikingowie.myecinema.repositories;

import com.wikingowie.myecinema.entities.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {
}
