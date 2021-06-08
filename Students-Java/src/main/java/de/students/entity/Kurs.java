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
public class Kurs {

    private String name;
    private Raum raum;

    public Kurs(String name, Raum raum) {
        this.name = name;
        this.raum = raum;

    }

    public String getName() {
        return name;
    }

    public Raum getRaum() {
        return raum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRaum(Raum raum) {
        this.raum = raum;
    }

}
