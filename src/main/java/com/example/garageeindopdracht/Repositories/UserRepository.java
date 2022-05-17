package com.example.garageeindopdracht.Repositories;

import com.example.garageeindopdracht.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        Optional<User> findByUsername(String username);


//        org.springframework.security.core.userdetails.User findByUsername(String username);
}