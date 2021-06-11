package de.students.db;

import de.students.entity.Firma;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DatabaseController {

    private final Session session;

    public DatabaseController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void shutdown() {
        HibernateUtil.shutdown();
    }

    // Kurse
    public List<Kurs> getKurse() {
        session.beginTransaction();
        List<Kurs> kurse = session.createQuery("from Kurs").list();
        session.getTransaction().commit();

        return kurse;
    }

    public Kurs getKursByName(String name) {
        return getKurse().stream()
                .filter(kurs -> name.equals(kurs.getName()))
                .findAny()
                .orElse(null);
    }

    public boolean kurseContains(String name) {
        return getKurse().stream().anyMatch(kurs -> name.equals(kurs.getName()));
    }

    public void insertKurs(Kurs kurs) {
        session.beginTransaction();
        session.save(kurs);
        session.getTransaction().commit();
    }

    public void updateKurs(Kurs kurs) {
        session.beginTransaction();
        session.merge(kurs);
        session.flush();
        session.getTransaction().commit();
    }

    public void deleteKurs(Kurs kurs) {
        session.beginTransaction();
        session.delete(kurs);
        session.getTransaction().commit();
    }

    // Studenten
    public List<Student> getStudenten() {
        session.beginTransaction();
        List<Student> studenten = session.createQuery("from Student").list();
        session.getTransaction().commit();

        return studenten;
    }

    public void insertStudent(Student student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public void updateStudent(Student student) {
        session.beginTransaction();
        session.merge(student);
        session.flush();
        session.getTransaction().commit();
    }

    public void deleteStudent(Student student) {
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
    }

    // Räume
    public List<Raum> getRaeume() {
        session.beginTransaction();
        List<Raum> raeume = session.createQuery("from Raum").list();
        session.getTransaction().commit();

        return raeume;
    }

    public void insertRaum(Raum raum) {
        session.beginTransaction();
        session.save(raum);
        session.getTransaction().commit();
    }

    public void updateRaum(Raum raum) {
        session.beginTransaction();
        session.merge(raum);
        session.flush();
        session.getTransaction().commit();
    }

    public void deleteRaum(Raum raum) {
        session.beginTransaction();
        session.delete(raum);
        session.getTransaction().commit();
    }


    // Firmen
    public List<Firma> getFirmen() {
        session.beginTransaction();
        List<Firma> firmen = session.createQuery("from Firma").list();
        session.getTransaction().commit();

        return firmen;
    }

    public void insertFirma(Firma firma) {
        session.beginTransaction();
        session.save(firma);
        session.getTransaction().commit();
    }

    public void updateFirma(Firma firma) {
        session.beginTransaction();
        session.merge(firma);
        session.flush();
        session.getTransaction().commit();
    }

    public void deleteFirma(Firma firma) {
        session.beginTransaction();
        session.delete(firma);
        session.getTransaction().commit();
    }


    // nur fürs Testen des DatabaseControllers
    public static void main(String[] args) {

        DatabaseController dbController = new DatabaseController();

        // select
        Kurs kurs = dbController.getKursByName("abc");
        if (kurs == null) System.out.println("Dieser Kurs ist nicht vorhanden");
        else System.out.println(kurs);

        // update
        /*kurs.setName("abc2");
        dbController.updateKurs(kurs);*/

        // insert
        /*Kurs newKurs = new Kurs();
        newKurs.setRaum(kurs.getRaum());
        newKurs.setName("test kurs");
        dbController.insertKurs(newKurs);  // Id von newKurs wird erst hier gesetzt
        System.out.println("newkurs Id: " + newKurs.getkId());*/

        // contains
        System.out.println(dbController.kurseContains("abc"));

    }
}
