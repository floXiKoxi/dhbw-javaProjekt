package de.students.entity;

import javax.persistence.*;

@Entity
@Table
public class Kurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kId;
    private String name;
    @ManyToOne
    private Raum raum;

    public Kurs(String name, Raum raum) {
        this.name = name;
        this.raum = raum;
    }

    public Kurs() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Raum getRaum() {
        return raum;
    }

    public void setRaum(Raum raum) {
        this.raum = raum;
    }

    public int getkId() {
        return kId;
    }

    public void setkId(int kId) {
        this.kId = kId;
    }

    public String getKurs() {
        return getName();
    }

    @Override
    public String toString() {
        return getKurs();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Kurs kurs = (Kurs) obj;
        return kurs.name.equals(this.name) && kurs.raum.equals(this.raum);
    }
}
