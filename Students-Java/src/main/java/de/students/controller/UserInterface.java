package de.students.controller;

import de.students.entity.Firma;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.entity.Student;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserInterface{

    @FXML private TableView<Kurs> kursTable;

    @FXML
    private void initialize() {

        kursTable.setEditable(true);

        kursTable.getItems().add(new Kurs("TINF", new Raum("B36")));

        kursTable.refresh();

    }

    public TableView getKursTable() {
        return kursTable;
    }
}
