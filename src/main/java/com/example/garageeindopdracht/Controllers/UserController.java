package com.example.garageeindopdracht.Controllers;

import com.example.garageeindopdracht.Models.ApplicationUser;
import com.example.garageeindopdracht.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/User/New")
    public String createUser(Model model) {
//        UserDetails newUser =
//                org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
//                        .username("admin")
//                        .password("admin")
//                        .roles("ADMIN") // Voegt automatisch ROLE_ toe
//                        .build();

        ApplicationUser newUser = new ApplicationUser();

        model.addAttribute("User", newUser);

        return "CreateUser";
    }

    // vraag een lijst met alle jobs op  ->  implementeert
    @GetMapping("/Users")
    public String getAllUsers(Model model) {
        List<ApplicationUser> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "Users"; // "Users" verwijst naar Users.html
    }

    // Sla aangemaakte user op in de database
    @PostMapping("/SaveUser")
    public String saveUser(@ModelAttribute("User") ApplicationUser newUser) {
        userService.newUser(newUser);
        return "SaveUser";
    }

    // Get methode voor de web-interface van de Edit methode
    @GetMapping("/User/{ID}/Edit")
    public String editUser(@PathVariable Long ID, Model model) {
        ApplicationUser existingUser = userService.getUser(ID);
        model.addAttribute("User", existingUser);
        return "EditUser";
    }

    // Vraag een specifieke user op -zonder webinterface
    @GetMapping("/User/{ID}")
    private ApplicationUser getUser(@PathVariable("ID") long ID) {
        return userService.getUser(ID);
    }

    // Pas een bestaande job aan
    @PostMapping("/User/{ID}")
    public String editUserFinished(@ModelAttribute("User") ApplicationUser editedUser) {
        // Onderstaande methode checkt of de user al bestaat, zo niet, dan maakt die een nieuwe aan
        userService.editUser(editedUser);
        return "EditUserFinished";
    }

    // Get methode om een user te verwijderen
    @GetMapping("/User/{ID}/Delete")
    public String deleteUser(@PathVariable Long ID, Model model) {
        ApplicationUser deletingUser = userService.getUser(ID);
        model.addAttribute("user", deletingUser);
        return "DeleteUser";
    }

    // Verwijder een user
    @PostMapping("/User/{ID}/Deleted")
    private String deleteUserFinished(@PathVariable long ID){
        userService.deleteUser(ID);
        return "DeleteUserFinished";
    }
}
