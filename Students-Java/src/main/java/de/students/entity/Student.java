package de.students.entity;

import javax.persistence.*;

@Entity
@Table
public class Student {

    @Id
    private int matrikelnummer;
    private String vorname, nachname;
    private int javaKentnisse;
    @ManyToOne
    private Kurs kurs;
    @ManyToOne
    private Firma firma;


    public Student(String vorname, String nachname, int matrikelnummer, Firma firma, Kurs kurs, int javaKentnisse){
        this.matrikelnummer = matrikelnummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.javaKentnisse = javaKentnisse;
        this.kurs = kurs;
        this.firma = firma;
    }
    
    public Student() { }


    public int getMatrikelnummer() {
        return matrikelnummer;
    }
    public void setMatrikelnummer(int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getJavaKentnisse() {
        return javaKentnisse;
    }
    public void setJavaKentnisse(int javaKentnisse) {
        this.javaKentnisse = javaKentnisse;
    }

    public Kurs getKurs() {
        return kurs;
    }
    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Firma getFirma() {
        return firma;
    }
    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    @Override
    public String toString() {
        return "{ matrikelnummer: " + matrikelnummer + ", vorname: " + vorname + ", nachname: " + nachname + ", javaKenntnisse: " + javaKentnisse + ", kurs: " + kurs.toString() + ", firma: " + firma.toString() + " }";
    }
}
