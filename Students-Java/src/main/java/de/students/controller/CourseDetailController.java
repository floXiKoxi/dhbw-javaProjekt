package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.entity.Student;
import de.students.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class CourseDetailController {

    private DatabaseController dbController = Main.dbController;
    public static String kursName;

    @FXML
    private TableView<Student> table;
    @FXML
    Label kursNameLabel;
    @FXML
    Label kursRaumLabel;

    @FXML
    private void initialize() {

        table.setEditable(true);

        fillTableWithKurs();
        updateKursDeatils();

    }

    public void fillTableWithKurs(){

        ObservableList<Student> studentsList = FXCollections.observableArrayList();

        dbController.getStudenten().forEach(x->studentsList.add(x));
        System.out.println(studentsList.size());
        for(Student student : studentsList){

            if(student.getKurs().getKurs() == this.kursName){

                table.setItems(studentsList);
                table.refresh();

            }

        }

    }
    public void updateKursDeatils(){

        Raum raum = dbController.getKursByName(kursName).getRaum();

        kursNameLabel.setText(kursName);
        kursRaumLabel.setText(raum.getRaumNr());

    }

}
