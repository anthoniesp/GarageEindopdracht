package com.example.garageeindopdracht.Repositories;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Models.User;
import com.example.garageeindopdracht.Security.ApplicationUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByStatus(int status);

}
