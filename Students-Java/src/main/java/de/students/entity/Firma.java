/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public int getfId() {
        return fId;
    }
}
