package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.List;

public class CoursePopupController {

    @FXML private Button btn_save;
    @FXML private TextField kurs;
    @FXML private ComboBox kursRaumDropDown;

    private DatabaseController dbController = Main.dbController;

    @FXML
    private void initialize() {
        fillComboBox();
    }

    @FXML
    public void saveCourse(ActionEvent e){

        Raum raum = (Raum) kursRaumDropDown.getSelectionModel().getSelectedItem();
        if(getKurs().length() >= 1 && raum != null){

            //dbController.insertRaum(raumObj);
            dbController.insertKurs(new Kurs(getKurs(), raum));
            nonBtnClick();
        }
        
    }
    @FXML
    private void nonBtnClick() {
        Stage s = (Stage) btn_save.getScene().getWindow();
        s.close();
    }

    public void fillComboBox(){

        List<Raum> raumList = dbController.getRaeume();

        kursRaumDropDown.getItems().clear();

        kursRaumDropDown.getItems().addAll(raumList);

    }

    public String getKurs(){

        return kurs.getText();

    }

}
