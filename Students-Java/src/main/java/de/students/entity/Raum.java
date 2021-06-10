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

    @Override
    public String toString() {
        return "{ rId: " + rId + ", raumNr: " + raumNr + " }";
    }
}
