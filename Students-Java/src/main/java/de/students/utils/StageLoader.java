package de.students.utils;

import de.students.controller.CoursePopupController;
import de.students.controller.StudentPopupController;
import de.students.entity.Kurs;
import de.students.entity.Student;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageLoader {

    private FXMLLoader fxmlLoader;
    private Parent parent;
    private Stage stage;
    private boolean isResizable;

    public StageLoader(String fxml_file) {

        setFxmlLoader(fxml_file);
        if (fxml_file == "CoursePopup.fxml" || fxml_file == "StudentPopup.fxml") {
            isResizable = false;
        }
    }

    public void openStage() {

        try {
            setParent(getFxmlLoader().load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(getParent()));
        stage.setResizable(isResizable);
        stage.showAndWait();
        stage.setAlwaysOnTop(true);

        setStage(stage);

    }

    public void openStageEdit(Kurs kurs) {

        try {
            setParent(getFxmlLoader().load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(getParent()));
        CoursePopupController controller = getFxmlLoader().getController();
        controller.initData(kurs);
        stage.setResizable(isResizable);
        //Wenn Stage geschlossen ist, dann macht weiter mit code.
        stage.showAndWait();
        stage.setAlwaysOnTop(true);

        setStage(stage);

    }

    public void openStageEditStudent(Student student) {

        try {
            setParent(getFxmlLoader().load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(getParent()));
        StudentPopupController controller = getFxmlLoader().getController();
        controller.initData(student);
        stage.setResizable(isResizable);
        //Wenn Stage geschlossen ist, dann macht weiter mit code.
        stage.setAlwaysOnTop(true);
        stage.showAndWait();

        setStage(stage);

    }

    public void openStage(String title) {

        try {
            setParent(getFxmlLoader().load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(getParent()));
        stage.setTitle(title);
        stage.setResizable(isResizable);
        stage.showAndWait();
        stage.setAlwaysOnTop(true);

        setStage(stage);
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public FXMLLoader getFxmlLoader() {

        return this.fxmlLoader;
    }

    public void setFxmlLoader(String name) {
        this.fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(name));
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void setResizableFalse() {
        this.isResizable = false;
    }
}
