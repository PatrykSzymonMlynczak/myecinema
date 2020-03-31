package com.wikingowie.myecinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wikingowie.myecinema.entities.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
}
