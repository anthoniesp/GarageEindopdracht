package com.example.garageeindopdracht.Repositories;

import com.example.garageeindopdracht.Models.User;
import com.example.garageeindopdracht.Security.ApplicationUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        User findByUserName(String userName);

        Optional<List<User>> findByApplicationUserRole(ApplicationUserRole admin);


//        org.springframework.security.core.userdetails.User findByUsername(String username);
}