package com.wikingowie.myecinema.repositories;

import com.wikingowie.myecinema.entities.ExampleEntity;
import com.wikingowie.myecinema.entities.UserData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
}
