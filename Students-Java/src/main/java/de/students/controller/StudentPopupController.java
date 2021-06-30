package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Firma;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.entity.Student;
import de.students.main.Main;
import de.students.utils.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentPopupController {

    @FXML
    private TextField input_vorname;
    @FXML
    private TextField input_nachname;
    @FXML
    private TextField input_matrikel;
    @FXML
    private TextField input_firma;
    @FXML
    private Slider slider_kenntnisse;
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

        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();

        String[] kursArray = stage.getTitle().split("-");

        if (getVorname().length() >= 1 && getNachname().length() >= 1 && getMatrikel_nummer().length() >= 1
                && getMatrikel_nummer().length() <8 && getFirma().length() >= 1) {

            if(Constants.isCorrect(getMatrikel_nummer()) == false){

                Firma firma = new Firma(getFirma(), "bla");
                Kurs kurs = getKurs(kursArray[0], kursArray[1]);
                int matrikel = Integer.parseInt(getMatrikel_nummer());

                Student student = new Student(getVorname(), getNachname(), matrikel, firma,
                        kurs, getJava_Kenntnisse());

                dbController.insertFirma(firma);

                if(kurs != null) dbController.insertKurs(kurs);

                dbController.insertStudent(student);
                nonBtnClick();

            }
        }

    }

    public Raum getRaum(String raumNummer){

        for(Raum raum : dbController.getRaeume()){

            if(raum.getRaumNr() == raumNummer){
                return raum;
            }

        }
        return null;
    }

    public Kurs getKurs(String kursname, String raum){

        for(Kurs kurs : dbController.getKurse()){

            System.out.println("Searching for: "+kursname + " Result: "+kurs.getKurs());

            if(kurs.getKurs().equals(kursname)){
                return kurs;
            }

        }
        return null;
    }

    @FXML
    private void nonBtnClick() {
        Stage s = (Stage) btn_save.getScene().getWindow();
        s.close();
    }

    public String getVorname() {
        return input_vorname.getText();
    }

    public String getNachname() {
        return input_nachname.getText();
    }

    public String getMatrikel_nummer() {
        return input_matrikel.getText();
    }

    public String getFirma() {
        return input_firma.getText();
    }

    public int getJava_Kenntnisse() {
        return (int) slider_kenntnisse.getValue();
    }

}
