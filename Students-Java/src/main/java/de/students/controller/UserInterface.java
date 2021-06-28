package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Firma;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.entity.Student;
import de.students.main.Main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.stage.WindowEvent;

public class UserInterface {

    @FXML
    private TableView<Kurs> kursTable;
    @FXML
    private Button btn_newKurs;
    @FXML
    private Button btn_delKurs;

    private DatabaseController dbController = Main.dbController;

    @FXML
    private void initialize() {

        kursTable.setEditable(true);
        setDeleteButtonUsage(false);

        fillTableWithKurs();
        openKursPopUp();
        pressTableRow();
    }

    public void setDeleteButtonUsage(boolean bool) {
        btn_delKurs.setVisible(bool);
        btn_delKurs.setDisable(!bool);
    }

    public void fillTableWithKurs() {

        ObservableList<Kurs> kursList = FXCollections.observableArrayList();

        dbController.getKurse().forEach(kurs -> kursList.add(kurs));

        kursTable.getItems().clear();
        kursTable.setItems(kursList);
        kursTable.refresh();

    }

    public void deleteKurs(Kurs kurs) {
        dbController.deleteKurs(kurs);
        fillTableWithKurs();
        setDeleteButtonUsage(false);
    }

    public void openKursPopUp() {

        btn_newKurs.setOnMouseClicked((MouseEvent event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("CoursePopup.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setAlwaysOnTop(true);

                //Wenn Stage geschlossen ist, dann macht weiter mit code.
                stage.showAndWait();

                fillTableWithKurs();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void pressTableRow() {

        kursTable.setRowFactory(tv -> {

            TableRow<Kurs> row = new TableRow<>();

            row.setOnMouseClicked(event -> {

                if (event.getClickCount() == 1 && (!row.isEmpty())) {

                    setDeleteButtonUsage(true);
                    Kurs rowData = row.getItem();

                    btn_delKurs.setOnMouseClicked(event1 -> {
                        deleteKurs(rowData);
                    });

                    row.setOnMouseClicked(event2 -> {

                        CourseDetailController.kursName = rowData.getKurs();

                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("CourseDetail.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();
                            stage.setAlwaysOnTop(true);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                }
            });
            return row;
        });
    }

    public TableView getKursTable() {
        return kursTable;
    }
}
