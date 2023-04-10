package com.nada.employes.controllers;

import com.nada.employes.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nada.employes.service.EmployeService;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeController {

    @Autowired
    EmployeService employeService;
    @RequestMapping("/showCreate")
    public String showCreate()
    {
        return "createEmploye";
    }

    @RequestMapping("/saveEmploye")
    public String saveEmploye(@ModelAttribute("employe") Employe employe,
                              @RequestParam("date") String date,
                              ModelMap modelMap) throws
            ParseException
    {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRec = dateformat.parse(String.valueOf(date));
        employe.setDateRec(dateRec);

        Employe saveEmploye = employeService.saveEmploye(employe);
        String msg ="employe enregistré avec Id "+saveEmploye.getIdEmploye();
        modelMap.addAttribute("msg", msg);
        return "createEmploye";
    }

    @RequestMapping("/ListeEmployes")
    public String listeEmployes(ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page<Employe> emps = employeService.getAllEmployesParPage(page, size);
        modelMap.addAttribute("employes", emps);
        modelMap.addAttribute("pages", new int[emps.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeEmployes";
    }


    @RequestMapping("/supprimerEmploye")
    public String supprimerEmploye(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam (name="page",defaultValue = "0") int page,
                                   @RequestParam (name="size", defaultValue = "2") int size)
    {
        employeService.deleteEmployeById(id);
        Page<Employe> emps = employeService.getAllEmployesParPage(page,
                size);
        modelMap.addAttribute("employes", emps);
        modelMap.addAttribute("pages", new int[emps.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeEmployes";
    }







}
