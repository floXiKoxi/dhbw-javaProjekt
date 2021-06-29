package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Kurs;
import de.students.entity.Raum;
import de.students.entity.Student;
import de.students.main.Main;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CourseDetailController {

    private DatabaseController dbController = Main.dbController;
    public static String kursName;
    private String kursPopupName;

    @FXML
    private TableView<Student> table;
    @FXML
    private Label kursNameLabel;
    @FXML
    private Label kursRaumLabel;
    @FXML
    private Button addStudent;
    @FXML
    private Button editStudent;

    @FXML
    private void initialize() {

        table.setEditable(true);

        fillTableWithStudent();
        updateKursDeatils();
        openStudentPopup();
        openEditStudentPopup();

    }

    public void fillTableWithStudent() {

        ObservableList<Student> studentsList = FXCollections.observableArrayList();

        dbController.getStudenten().forEach(x -> studentsList.add(x));

        for (Student student : studentsList) {

            if (student.getKurs().getKurs().equals(this.kursName)) {
                table.setItems(studentsList);
                table.refresh();
            }
        }
    }

    public void updateKursDeatils() {

        Raum raum = dbController.getKursByName(kursName).getRaum();

        kursNameLabel.setText(kursName);
        kursRaumLabel.setText(raum.getRaumNr());

    }

    public void openStudentPopup() {

        addStudent.setOnMouseClicked((MouseEvent event) -> {
            try {
                Stage s = (Stage)((Node) event.getSource()).getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("StudentPopup.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle(s.getTitle());
                stage.setAlwaysOnTop(true);

                //Wenn Stage geschlossen ist, dann macht weiter mit code.
                stage.showAndWait();
                fillTableWithStudent();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
    public void openEditStudentPopup() {

        editStudent.setOnMouseClicked((MouseEvent event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("StudentPopup.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setAlwaysOnTop(true);

                //Wenn Stage geschlossen ist, dann macht weiter mit code.
                stage.showAndWait();

                fillTableWithStudent();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void pressTableRow() {

        table.setRowFactory(tv -> {

            TableRow<Kurs> row = new TableRow<>();

            row.setOnMouseClicked(event -> {

                Kurs rowData = row.getItem();
                setKursPopupName(rowData.getKurs());

            });
            return null;
        });
    }

    public String getKursPopupName() {
        return kursPopupName;
    }

    public void setKursPopupName(String kursPopupName) {
        this.kursPopupName = kursPopupName;
    }
}
