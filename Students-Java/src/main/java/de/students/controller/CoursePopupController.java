package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CoursePopupController {

    @FXML private Button btn_save;
    @FXML private TextField kurs;
    @FXML private TextField raum;

    private DatabaseController dbController = Main.dbController;

    @FXML
    private void initialize() {
    }

    @FXML
    public void saveCourse(ActionEvent e){

        if(getKurs().length() >= 1 && getRaum().length() >= 1){

            dbController.insertKurs(new Kurs(getKurs(), null));

            Stage stage = (Stage) btn_save.getScene().getWindow();
            stage.close();

        }

    }

    public String getKurs(){

        return kurs.getText();

    }
    public String getRaum(){

        return raum.getText();

    }

}
