package de.students.db;

import de.students.entity.Firma;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.entity.Student;
import org.hibernate.Session;

public class DatabaseController {

    // für Testen des DatabaseControllers
    public static void main(String[] args) {
        /*Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Student student = new Student();

        Firma firma = new Firma("Firma 1", "Straße 1");
        session.save(firma);

        Raum raum = new Raum("5");
        session.save(raum);

        Kurs kurs = new Kurs("abc", raum);
        session.save(kurs);

        student.setMatrikelnummer(123);
        student.setVorname("ABC");
        student.setNachname("DEF");
        student.setJavaKentnisse(5);
        student.setFirma(firma);
        student.setKurs(kurs);

        session.save(student);
        session.getTransaction().commit();*/
    }
}
