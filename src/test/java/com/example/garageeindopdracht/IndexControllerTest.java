package com.example.garageeindopdracht;

import com.example.garageeindopdracht.Controllers.IndexController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexControllerTest {

    IndexController indexController = new IndexController();

    @Test
    void shouldGetAdmin() {
        assertEquals("AdminIndex", indexController.getAdminIndex());
    }

    @Test
    void shouldGetAdministrativeWorker() {
        assertEquals("AdministrativeWorkerIndex", indexController.getAdministrativeWorkerIndex());
    }

    @Test
    void shouldGetMechanic() {
        assertEquals("MechanicIndex", indexController.getMechanicIndex());
    }
}
