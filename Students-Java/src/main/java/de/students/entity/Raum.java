package de.students.entity;

import javax.persistence.*;

@Entity
@Table
public class Raum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rId;
    private String raum;

    public Raum(String raumNr) {
        this.raum = raumNr;
    }

    public Raum() {
    }

    public String getRaumNr() {
        return raum;
    }

    public void setRaumNr(String raumNr) {
        this.raum = raumNr;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    @Override
    public String toString() {
        return raum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Raum raumObj = (Raum) obj;
        return this.raum.equals(raumObj.raum);
    }
}
