/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.students.entity;

import javax.persistence.*;

@Entity
@Table
public class Raum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rId;

    private String raumNr;


    public Raum(String raumNr) {
        this.raumNr = raumNr;
    }
    public Raum() { }


    public String getRaumNr() {
        return raumNr;
    }
    public void setRaumNr(String raumNr) {
        this.raumNr = raumNr;
    }
    public int getrId() {
        return rId;
    }
    public void setrId(int rId) {
        this.rId = rId;
    }
}
