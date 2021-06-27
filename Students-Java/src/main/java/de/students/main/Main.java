package de.students.main;

import de.students.db.DatabaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main  extends Application{

    public static DatabaseController dbController = new DatabaseController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UserInterface.fxml"));
        stage.setTitle("DHBW Studentenverwaltung");
        stage.setScene(new Scene(root));
        stage.show();

    }

}
