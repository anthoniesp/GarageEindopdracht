package com.example.garageeindopdracht.Repositories;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}