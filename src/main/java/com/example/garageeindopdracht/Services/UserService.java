package com.example.garageeindopdracht.Services;

import com.example.garageeindopdracht.Models.User;
import com.example.garageeindopdracht.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user != null) {
//            return (UserDetails)user;
//        } else {
//            throw new UsernameNotFoundException(username);
//        }
//
//    }

    public List<User> getAllUsers() {
        List<User> userList;
        userList = userRepository.findAll();
        return userList;
    }

    public User getUser(long ID) {
        return userRepository.findById(ID).orElse( null);
    }

    public void newUser(User newUser) {
        if (userRepository.findById(newUser.getUserID()).isPresent()) {
            throw new RuntimeException("User does already exist");

        } else {
//            userRepository.findById(newUser.getUserID()).map(
//                    user -> {
//                        user.setUserName(newUser.getUserName());
//                        user.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
//                        user.setApplicationUserRole(newUser.getApplicationUserRole());
//
//                        return userRepository.save(user);
//                    });
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            userRepository.save(newUser);
        }
    }

    // https://github.com/V-hofman/huiswerkspring1/blob/extra/huiswerkspring2/src/main/java/com/example/huiswerkspring1/services/AppService.java
    // Copy-pasted
    public void editUser(User editedUser) {
        //Hier zeggen we stuur iets terug, namelijk zoek een author met een ID
        userRepository.findById(editedUser.getUserID())
                //Kan je hem vinden? dan doen we een .map, dit overschrijft de author die we vonden
                .map(
                        user -> { //Voor een functie body { } uit en ik verwacht een author terug.
                            //setters van de author die is opgeslagen, die nu de waarde krijgen van de BODY die we in het PUT hadden geplaatst.
                            //TODO            job.setName(editedJob.getName());
                            //TODO            job.setMembershipLevel(editedJob.getMembershipLevel());
                            user.setUserID(editedUser.getUserID());
                            user.setUserName(editedUser.getUserName());
                            user.setPassword(editedUser.getPassword());
                            user.setApplicationUserRole(editedUser.getApplicationUserRole());
                            //Gegevens veranderd? dan slaan we hem op.
                            return userRepository.save(user);
                        }).orElseGet(() -> { //Kan je hem niet vinden? Dan slaan we in dit geval gewoon een nieuwe op.
                    editedUser.setUserID(editedUser.getUserID());
                    return userRepository.save(editedUser);
                });
    }

    public void deleteUser(long ID) {
        User deletingUser = userRepository.findById(ID).orElse(null);
        if (deletingUser != null) {
            userRepository.delete(deletingUser);
        }
    }
}
