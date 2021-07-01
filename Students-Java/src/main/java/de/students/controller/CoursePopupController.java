package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.main.Main;
import de.students.utils.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;
import javafx.scene.control.Label;

public class CoursePopupController {
    
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_edit;
    @FXML
    private TextField kurs;
    @FXML
    private ComboBox kursRaumDropDown;
    @FXML
    private Label label_error;
    
    private Kurs selectedKurs;
    
    private DatabaseController dbController = Main.dbController;
    
    @FXML
    private void initialize() {
        setButtonUsages(true);
        fillComboBox();
    }
    
    public void setButtonUsage(Button button, boolean bool) {
        button.setVisible(bool);
        button.setDisable(!bool);
    }
    
    public void setButtonUsages(boolean bool) {     // sets buttons to edit-Mode if true
        setButtonUsage(btn_save, bool);
        setButtonUsage(btn_edit, !bool);
    }
    
    @FXML
    public void saveCourse(ActionEvent e) {
        if (Constants.isCorrectKursName(getKurs()) && getRaum() != null) {
            
            dbController.insertKurs(new Kurs(getKurs(), getRaum()));
            nonBtnClick();
        } else {
            label_error.setText("Nicht unterstütztes Zeichen oder leeres Feld!");
        }
    }
    
    @FXML
    public void editCourse(ActionEvent e) {
        if (Constants.isCorrectKursName(getKurs())) {
            selectedKurs.setName(getKurs());
            selectedKurs.setRaum(getRaum());
            dbController.updateKurs(selectedKurs);
            nonBtnClick();
        } else {
            label_error.setText("Nicht unterstütztes Zeichen oder leeres Feld!");
        }
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
        setButtonUsages(false);
        selectedKurs = kurs;
        
    }
}
