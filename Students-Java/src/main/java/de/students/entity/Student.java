package de.students.entity;

public class Student {

    private String vorname, nachname;
    private int javaKentnisse;
    private Raum raum;
    private Kurs kurs;
    private Firma firma;

    public Student(String vorname, String nachname, int javaKentnisse, Firma firma, Raum raum, Kurs kurs){

        this.vorname = vorname;
        this.nachname = nachname;
        this.javaKentnisse = javaKentnisse;
        this.kurs = kurs;
        this.raum = raum;
        this.firma = firma;
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

    public Raum getRaum() {
        return raum;
    }

    public void setRaum(Raum raum) {
        this.raum = raum;
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
}
