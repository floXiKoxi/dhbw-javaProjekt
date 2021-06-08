package de.students.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUIController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        Button button = new Button("Klick");
        button.setPrefWidth(100.0);
        root.add(button,0,0 );
        Label label = new Label();
        label.setPrefWidth(100.0);
        label.setAlignment(Pos.CENTER);
        root.add(label,0,1 );

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText(new FXMLBspModel().getHello());
            }
        });
        primaryStage.setTitle("FXML-Beispiel");
        primaryStage.setScene(new Scene(root, 100, 57));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}