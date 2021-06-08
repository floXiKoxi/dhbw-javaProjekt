/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.students.entity;

/**
 *
 * @author yiwen
 */
public class Firma {

    private String name;
    private String addresse;

    public Firma(String name, String addresse) {
        this.name = name;
        this.addresse = addresse;
    }

    public String getName() {
        return name;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

}
