package com.example.garageeindopdracht.Controllers;

import com.example.garageeindopdracht.Models.Job;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/Admin")
    private String getAdminIndex() {
        return "AdminIndex";
    }

    @GetMapping("/Administration")
    private String getAdministrativeWorkerIndex() {
        return "AdministrativeWorkerIndex";
    }

    @GetMapping("/Mechanic")
    private String getMechanicIndex() {
        return "MechanicIndex";
    }
}
