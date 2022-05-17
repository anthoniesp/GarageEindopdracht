package com.example.garageeindopdracht.Services;

import com.example.garageeindopdracht.Models.ApplicationUser;
import com.example.garageeindopdracht.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<ApplicationUser> getAllUsers() {
        List<ApplicationUser> userList;
        userList = userRepository.findAll();
        return userList;
    }

    public ApplicationUser getUser(long ID) {
        return userRepository.findById(ID).orElse( null);
    }

    public void newUser(ApplicationUser newUser) {
//        newJob.setID(ID);
        if (userRepository.findById(newUser.getID()).isPresent()) {
//            jobRepository.findById(newJob.getID()).map(
//                    job -> {
//                        job.setCarLicensePlate(newJob.getCarLicensePlate());
//                        job.setCustomerName(newJob.getCustomerName());
//                        job.setCustomerPhoneNumber(newJob.getCustomerPhoneNumber());
//                        job.setJobDescription(newJob.getJobDescription());
//                    }
//            )

        } else {
            userRepository.save(newUser);
        }
    }

    // https://github.com/V-hofman/huiswerkspring1/blob/extra/huiswerkspring2/src/main/java/com/example/huiswerkspring1/services/AppService.java
    // Copy-pasted
    public void editUser(ApplicationUser editedUser) {
        //Hier zeggen we stuur iets terug, namelijk zoek een author met een ID
        userRepository.findById(editedUser.getID())
                //Kan je hem vinden? dan doen we een .map, dit overschrijft de author die we vonden
                .map(
                        user -> { //Voor een functie body { } uit en ik verwacht een author terug.
                            //setters van de author die is opgeslagen, die nu de waarde krijgen van de BODY die we in het PUT hadden geplaatst.
                            //TODO            job.setName(editedJob.getName());
                            //TODO            job.setMembershipLevel(editedJob.getMembershipLevel());
                            user.setID(editedUser.getID());
                            user.setUserName(editedUser.getUserName());
                            user.setPassword(editedUser.getPassword());
                            user.setRole(editedUser.getRole());
                            //Gegevens veranderd? dan slaan we hem op.
                            return userRepository.save(user);
                        }).orElseGet(() -> { //Kan je hem niet vinden? Dan slaan we in dit geval gewoon een nieuwe op.
                    editedUser.setID(editedUser.getID());
                    return userRepository.save(editedUser);
                });
    }

    public void deleteUser(long ID) {
        ApplicationUser deletingUser = userRepository.findById(ID).orElse(null);
        if (deletingUser != null) {
            userRepository.delete(deletingUser);
        }
    }
}
