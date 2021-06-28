package de.students.entity;

import javax.persistence.*;

@Entity
@Table
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fId;
    private String name;
    private String adresse;

    public Firma(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    public Firma() {
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public int getfId() {
        return fId;
    }

    @Override
    public String toString() {
        return name;
    }

}
