package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class CoursePopupController {

    @FXML
    private Button btn_save;
    @FXML
    private Button btn_edit;
    @FXML
    private TextField kurs;
    @FXML
    private ComboBox kursRaumDropDown;

    private Kurs selectedKurs;

    private DatabaseController dbController = Main.dbController;

    @FXML
    private void initialize() {
        setButtonUsage(btn_save, true);
        setButtonUsage(btn_edit, false);
        fillComboBox();
    }

    public void setButtonUsage(Button button, boolean bool) {
        button.setVisible(bool);
        button.setDisable(!bool);
    }

    @FXML
    public void saveCourse(ActionEvent e) {
        if (getKurs().length() >= 1 && getRaum() != null) {

            dbController.insertKurs(new Kurs(getKurs(), getRaum()));
            nonBtnClick();
        }
    }

    @FXML
    public void editCourse(ActionEvent e) {
        selectedKurs.setName(getKurs());
        selectedKurs.setRaum(getRaum());
        dbController.updateKurs(selectedKurs);
        nonBtnClick();
    }

    @FXML
    private void nonBtnClick() {
        Stage s = (Stage) btn_save.getScene().getWindow();
        s.close();
    }

    public void fillComboBox() {

        List<Raum> raumList = dbController.getRaeume();
        kursRaumDropDown.getItems().clear();
        kursRaumDropDown.getItems().addAll(raumList);

    }

    public String getKurs() {
        return kurs.getText();
    }

    public Raum getRaum() {
        return (Raum) kursRaumDropDown.getSelectionModel().getSelectedItem();
    }

    public void initData(Kurs kurs) {
        this.kurs.setText(kurs.getName());
        setButtonUsage(btn_save, false);
        setButtonUsage(btn_edit, true);
        selectedKurs = kurs;

    }
}
