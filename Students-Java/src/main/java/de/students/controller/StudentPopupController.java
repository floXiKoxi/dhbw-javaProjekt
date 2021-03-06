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
import javafx.scene.control.Label;
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
    @FXML
    private Button btn_edit;
    @FXML
    private Label label_error;

    Student selectedStudent;

    private DatabaseController dbController = Main.dbController;

    @FXML
    private void initialize() {
        label_error.setText("");
        setButtonUsages(false);
    }

    public void setButtonUsage(Button button, boolean bool) {
        button.setVisible(bool);
        button.setDisable(!bool);
    }

    @FXML
    public void saveStudent(ActionEvent e) {

        //Stage getten und aus der Stage den Titel getten um Kurs zu indentifizieren
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        String[] kursArray = stage.getTitle().split("-");

        if (Constants.isCorrectName(getVorname()) && Constants.isCorrectName(getNachname())
                && Constants.isCorrectFirma(getFirma())) {

            if (Constants.isCorrect(getMatrikel_nummer()) == true) {

                if(matrikelExits(getMatrikel_nummer()) == false){

                    int matrikel = Integer.parseInt(getMatrikel_nummer());
                    Firma firma = new Firma(getFirma(), "bla");
                    Kurs kurs = getKurs(kursArray[0], kursArray[1]);
                    Student student = new Student(getVorname(), getNachname(), matrikel, firma,
                            kurs, getJava_Kenntnisse());

                    dbController.insertFirma(firma);

                    if (kurs != null) {
                        dbController.insertKurs(kurs);
                    }

                    dbController.insertStudent(student);
                    nonBtnClick();

                }else {

                    label_error.setText("Matrikel-Nr. existiert");

                }

            } else {
                label_error.setText("Invalide Matrikel-Nr.!");
            }

        } else {
            label_error.setText("Bitte alles ausf??llen!");
        }
    }

    @FXML
    public void editStudent(ActionEvent e) {
        selectedStudent.setVorname(getVorname());
        selectedStudent.setNachname(getNachname());
        selectedStudent.setMatrikelnummer(Integer.parseInt(getMatrikel_nummer()));
        selectedStudent.setJavaKentnisse(getJava_Kenntnisse());
        dbController.updateStudent(selectedStudent);
        nonBtnClick();
    }

    @FXML
    public void deleteStudent(ActionEvent e) {
        dbController.deleteStudent(selectedStudent);
        nonBtnClick();
    }

    public Raum getRaum(String raumNummer) {

        for (Raum raum : dbController.getRaeume()) {

            if (raum.getRaumNr() == raumNummer) {
                return raum;
            }

        }
        return null;
    }

    public Kurs getKurs(String kursname, String raum) {

        for (Kurs kurs : dbController.getKurse()) {

            if (kurs.getKurs().equals(kursname)) {
                return kurs;
            }

        }
        return null;
    }

    public boolean matrikelExits(String matrikel){

        for(Student student : dbController.getStudenten()){

            if(student.getMatrikelnummer() == Integer.valueOf(matrikel)){
                return true;
            }

        }
        return false;
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

    public void initData(Student student) {
        this.input_vorname.setText(student.getVorname());
        this.input_nachname.setText(student.getNachname());
        this.input_matrikel.setText(student.getMatrikelnummer() + "");
        this.input_firma.setText(student.getFirma().getName());
        this.slider_kenntnisse.setValue(student.getJavaKentnisse());
        this.selectedStudent = student;
        setButtonUsages(true);
    }

    public void setButtonUsages(boolean set) {

        if (set == true) {

            setButtonUsage(btn_delete, true);
            setButtonUsage(btn_edit, true);
            setButtonUsage(btn_save, false);

        } else {
            setButtonUsage(btn_delete, false);
            setButtonUsage(btn_edit, false);
            setButtonUsage(btn_save, true);
        }

    }
}
