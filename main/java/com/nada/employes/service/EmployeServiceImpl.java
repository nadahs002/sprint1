package com.nada.employes.service;
import com.nada.employes.entities.Employe;
import com.nada.employes.repos.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    EmployeRepository employeRepository;

    @Override
    public Employe saveEmploye(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public Employe updateEmploye(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public void deleteEmploye(Employe e) {
        employeRepository.delete(e);

    }

    @Override
    public void deleteEmployeById(Long id) {
        employeRepository.deleteById(id);

    }

    @Override
    public Employe getEmploye(Long id) {
        return employeRepository.findById(id).get();
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Page<Employe> getAllEmployesParPage(int page, int size) {
        return employeRepository.findAll(PageRequest.of(page, size));
    }

}
