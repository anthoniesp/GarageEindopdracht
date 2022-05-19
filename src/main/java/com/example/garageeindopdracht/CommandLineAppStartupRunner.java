package com.example.garageeindopdracht;

import com.example.garageeindopdracht.Models.User;
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
    CommandLineRunner commandLineRunner(UserRepository userRepository){
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
            }
        };
    }
}
