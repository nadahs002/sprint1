package com.nada.employes.service;

import com.nada.employes.entities.Employe;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeService {

    Employe saveEmploye(Employe e);
    Employe updateEmploye (Employe e);
    void deleteEmploye(Employe e);
    void deleteEmployeById(Long id);
    Employe getEmploye(Long id);
    List<Employe> getAllEmployes();

    Page<Employe> getAllEmployesParPage(int page, int size);

}
