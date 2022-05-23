package com.example.garageeindopdracht.Controllers;

import com.example.garageeindopdracht.Models.Job;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/Admin")
    public String getAdminIndex() {
        return "AdminIndex";
    }

    @GetMapping("/Administration")
    public String getAdministrativeWorkerIndex() {
        return "AdministrativeWorkerIndex";
    }

    @GetMapping("/Mechanic")
    public String getMechanicIndex() {
        return "MechanicIndex";
    }
}
