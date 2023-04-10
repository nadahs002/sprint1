package com.nada.employes.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity

public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    private String nomEmploye;
    private Double salaire;
    private Date dateRec;

    public Employe() {
        super();
    }

    public Employe(String nomEmploye, Double salaire, Date dateRec) {
        super();
        this.nomEmploye = nomEmploye;
        this.salaire = salaire;
        this.dateRec = dateRec;
    }

    public Long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Long idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Date getDateRec() {
        return dateRec;
    }

    public void setDateRec(Date dateRec) {
        this.dateRec = dateRec;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "idEmploye=" + idEmploye +
                ", nomEmploye='" + nomEmploye + '\'' +
                ", salaire=" + salaire +
                ", dateRec=" + dateRec +
                '}';
    }
}
