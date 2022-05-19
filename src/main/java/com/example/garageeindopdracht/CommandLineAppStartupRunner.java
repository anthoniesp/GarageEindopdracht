package com.example.garageeindopdracht;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Models.User;
import com.example.garageeindopdracht.Repositories.JobRepository;
import com.example.garageeindopdracht.Repositories.UserRepository;
import com.example.garageeindopdracht.Security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Deze class wordt uitgevoerd zodra het programma start, als er dan nog geen admin gebruiker in de database staat, wordt deze aangemaakt
@Configuration
@AllArgsConstructor
public class CommandLineAppStartupRunner {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, JobRepository jobRepository){
        return args -> {

            if(userRepository.findAll().isEmpty()) {
                User admin = User.builder()
                        .userName("admin")
                        .password(bCryptPasswordEncoder.encode("admin"))
                        .applicationUserRole(ApplicationUserRole.ADMIN)
                        .build();

                User adwork = User.builder()
                        .userName("adwork")
                        .password(bCryptPasswordEncoder.encode("adwork"))
                        .applicationUserRole(ApplicationUserRole.ADMINISTRATIVE_WORKER)
                        .build();

                User mech = User.builder()
                        .userName("mech")
                        .password(bCryptPasswordEncoder.encode("mech"))
                        .applicationUserRole(ApplicationUserRole.MECHANIC)
                        .build();

                userRepository.save(admin);
                userRepository.save(adwork);
                userRepository.save(mech);

                if(jobRepository.findAll().isEmpty()) {
                    Job job1 = new Job("31-HDR-2", "Jeroen", "0625965481", "Alles is kapot",0);
                    Job job2 = new Job("24-GKT-7", "Tygo", "0625936881", "Remmen lopen aan",0);
                    Job job3 = new Job("79-FHJ-1", "Susan", "0625964896", "Start niet",1);
                    Job job4 = new Job("57-FKR-9", "Kaitlyn", "0625548481", "Voorruit mist",0);
                    Job job5 = new Job("49-HDR-2", "Karel", "0625595481", "Frame ontbreekt",1);
                    Job job6 = new Job("58-DHR-2", "Paul", "0625965481", "Stuur los",0);
                    Job job7 = new Job("96-HRP-2", "Sjon", "0625569481", "Koppeling kapot",1);

                    jobRepository.save(job1);
                    jobRepository.save(job2);
                    jobRepository.save(job3);
                    jobRepository.save(job4);
                    jobRepository.save(job5);
                    jobRepository.save(job6);
                    jobRepository.save(job7);
            }
        }
    };

//    @Bean
//    CommandLineRunner commandLineRunner(JobRepository jobRepository){
//        return args -> {
//
//            if(jobRepository.findAll().isEmpty()) {
//                Job job1 = new Job("31-HDR-2", "Jeroen", "0625965481", "Alles is kapot",0);
//                Job job2 = new Job("24-GKT-7", "Tygo", "0625936881", "Remmen lopen aan",0);
//                Job job3 = new Job("79-FHJ-1", "Susan", "0625964896", "Start niet",1);
//                Job job4 = new Job("57-FKR-9", "Kaitlyn", "0625548481", "Voorruit mist",0);
//                Job job5 = new Job("49-HDR-2", "Karel", "0625595481", "Frame ontbreekt",1);
//                Job job6 = new Job("58-DHR-2", "Paul", "0625965481", "Stuur los",0);
//                Job job7 = new Job("96-HRP-2", "Sjon", "0625569481", "Koppeling kapot",1);
//
//                jobRepository.save(job1);
//                jobRepository.save(job2);
//                jobRepository.save(job3);
//                jobRepository.save(job4);
//                jobRepository.save(job5);
//                jobRepository.save(job6);
//                jobRepository.save(job7);
//            }
//        };
//    }
}}
