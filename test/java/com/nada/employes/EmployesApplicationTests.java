package com.nada.employes;

import com.nada.employes.entities.Employe;
import com.nada.employes.repos.EmployeRepository;
import com.nada.employes.service.EmployeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;


import java.util.Date;
import java.util.List;

@SpringBootTest
class EmployesApplicationTests {
    @Autowired
    private EmployeRepository employeRepository;
    private EmployeService employeService;


    @Test
    public void testCreateEmploye() {
        Employe emp = new Employe("nada", 2200.500, new Date());
        employeRepository.save(emp);
    }

    @Test
    public void testFindEmploye() {
        Employe e = employeRepository.findById(1L).get();
        System.out.println(e);
    }

    @Test
    public void testUpdateEmploye() {
        Employe e = employeRepository.findById(1L).get();
        e.setSalaire(2000.0);
        employeRepository.save(e);
    }


    @Test
    public void testDeleteEmploye() {
        employeRepository.deleteById(1L);
        ;
    }

    @Test
    public void testListerTousEmploye() {
        List<Employe> emps = employeRepository.findAll();
        for (Employe e : emps) {
            System.out.println(e);
        }
    }

    @Test
    public void testFindByNomEmployeContains() {
        Page<Employe> emps = employeService.getAllEmployesParPage(0, 2);
        System.out.println(emps.getSize());
        System.out.println(emps.getTotalElements());
        System.out.println(emps.getTotalPages());
        emps.getContent().forEach(p -> {
            System.out.println(p.toString());
        });

    }




}
