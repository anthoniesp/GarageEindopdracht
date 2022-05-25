package com.example.garageeindopdracht.Controllers;

import com.example.garageeindopdracht.Models.User;
import com.example.garageeindopdracht.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
        User newUser = new User();
        model.addAttribute("User", newUser);
        return "User/CreateUser";
    }

    // vraag een lijst met alle jobs op  ->  implementeert
    @GetMapping("/Users")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "User/Users"; // "Users" verwijst naar Users.html
    }

    // Sla aangemaakte user op in de database
    @PostMapping("/User/SaveUser")
    public String saveUser(@ModelAttribute("User") User newUser) {
        userService.newUser(newUser);
        return "User/SaveUser";
    }

    // Get methode voor de web-interface van de Edit methode
    @GetMapping("/User/{ID}/Edit")
    public String editUser(@PathVariable Long ID, Model model) {
        User existingUser = userService.getUser(ID);
        model.addAttribute("User", existingUser);
        return "User/EditUser";
    }

    // Vraag een specifieke user op -zonder webinterface
    @GetMapping("/User/{ID}")
    private User getUser(@PathVariable("ID") long ID) {
        return userService.getUser(ID);
    }

    // Pas een bestaande job aan
    @PostMapping("/User/{ID}")
    public String editUserFinished(@ModelAttribute("User") User editedUser, @PathVariable("ID") long ID) {
        editedUser.setUserID(ID);
        userService.editUser(editedUser);
        return "User/EditUserFinished";
    }

    // Get methode om een user te verwijderen
    @GetMapping("/User/{ID}/Delete")
    public String deleteUser(@PathVariable Long ID, Model model) {
        User deletingUser = userService.getUser(ID);
        model.addAttribute("user", deletingUser);
        return "User/DeleteUser";
    }

    // Verwijder een user
    @PostMapping("/User/{ID}/Deleted")
    private String deleteUserFinished(@PathVariable long ID){
        userService.deleteUser(ID);
        return "User/DeleteUserFinished";
    }
}
