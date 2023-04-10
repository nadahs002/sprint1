package com.nada.employes;

import com.nada.employes.entities.Employe;
import com.nada.employes.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class EmployesApplication implements CommandLineRunner {

    @Autowired
    EmployeService employeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // employeService.saveEmploye(new Employe("Nada", 2600.0, new Date()));

    }


}
