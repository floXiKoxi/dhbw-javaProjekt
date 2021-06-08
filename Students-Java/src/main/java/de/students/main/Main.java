package de.students.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label label = new Label("Hello World! :)");
        stage.setScene(new Scene(label, 250, 100));
        stage.setTitle("Hello JavaFX");
        stage.show();

    }
}
