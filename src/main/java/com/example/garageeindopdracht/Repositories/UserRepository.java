package com.example.garageeindopdracht.Repositories;

import com.example.garageeindopdracht.Models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

        User findByUsername(String username);
}