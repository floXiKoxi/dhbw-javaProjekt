package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Firma;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.entity.Student;
import de.students.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentPopupController {

    @FXML
    private TextField vorname;
    @FXML
    private TextField nachname;
    @FXML
    private TextField matrikel_nummer;
    @FXML
    private TextField firma;
    @FXML
    private Slider java_kenntnisse;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_save;

    private DatabaseController dbController = Main.dbController;

    @FXML
    private void initialize() {

    }

    @FXML
    public void saveStudent(ActionEvent e) {

        if (getVorname().length() >= 1 && getNachname().length() >= 1 && getMatrikel_nummer().length() >= 1 && getFirma().length() >= 1) {

            dbController.insertStudent(new Student(getVorname(), getNachname(), Integer.parseInt(getMatrikel_nummer()), new Firma(getFirma(), ""), new Kurs(), getJava_Kenntnisse()));  // parse könnte Probleme machen. Fehler catchen
            nonBtnClick();
        }

    }

    @FXML
    private void nonBtnClick() {
        Stage s = (Stage) btn_save.getScene().getWindow();
        s.close();
    }

    public String getVorname() {
        return vorname.getText();
    }

    public String getNachname() {
        return nachname.getText();
    }

    public String getMatrikel_nummer() {
        return matrikel_nummer.getText();
    }

    public String getFirma() {
        return firma.getText();
    }

    public int getJava_Kenntnisse() {
        return (int) java_kenntnisse.getValue();
    }

}
