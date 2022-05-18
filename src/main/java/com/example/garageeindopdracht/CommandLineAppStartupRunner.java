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

/**
 * Class runs before actual program starts and loads database with an admin user and a customer user.
 */
@Configuration
@AllArgsConstructor
public class CommandLineAppStartupRunner {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            if(userRepository.findByApplicationUserRole(ApplicationUserRole.ADMIN).isEmpty()) {
                User admin = User.builder()
                        .userName("Admin")
                        .password(bCryptPasswordEncoder.encode("VeryGoodPassword"))
                        .applicationUserRole(ApplicationUserRole.ADMIN)
                        .build();

                    userRepository.save(admin);
            }
        };
    }
}
