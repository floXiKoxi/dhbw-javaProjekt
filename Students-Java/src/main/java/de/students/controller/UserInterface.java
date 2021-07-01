package de.students.controller;

import de.students.db.DatabaseController;
import de.students.entity.Kurs;
import de.students.main.Main;
import de.students.utils.StageLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class UserInterface {

    private String kursNameClick;

    @FXML
    private TableView<Kurs> kursTable;
    @FXML
    private Button btn_newKurs;
    @FXML
    private Button btn_delKurs;
    @FXML
    private Button btn_editKurs;

    private final DatabaseController dbController = Main.dbController;

    @FXML
    private void initialize() {

        kursTable.setEditable(true);
        setButtonUsages(false);
        fillTableWithKurs();
        openKursPopUp();
        pressTableRow();
    }

    public void setButtonUsage(Button button, boolean bool) {
        button.setVisible(bool);
        button.setDisable(!bool);
    }

    public void setButtonUsages(boolean bool) {      // set Button usages to editable and deletable if true
        setButtonUsage(btn_delKurs, bool);
        setButtonUsage(btn_editKurs, bool);
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
        setButtonUsages(false);
    }

    public void openKursPopUp() {

        btn_newKurs.setOnMouseClicked((MouseEvent event) -> {

            StageLoader loader = new StageLoader("CoursePopup.fxml");
            loader.openStage();
            fillTableWithKurs();
        });

    }

    public void pressTableRow() {

        kursTable.setRowFactory(tv -> {

            TableRow<Kurs> row = new TableRow<>();

            row.setOnMouseClicked(event -> {

                if (event.getClickCount() == 1 && (!row.isEmpty())) {

                    setButtonsUsage(true);
                    Kurs rowData = row.getItem();

                    btn_delKurs.setOnMouseClicked(event1 -> {
                        deleteKurs(rowData);
                    });

                    btn_editKurs.setOnMouseClicked(event2 -> {
                        StageLoader loader = new StageLoader("CoursePopup.fxml");
                        loader.openStageEdit(rowData);
                        fillTableWithKurs();
                        setButtonsUsage(false);

                    });

                    row.setOnMouseClicked(event3 -> {

                        CourseDetailController.kursName = rowData.getKurs();

                        StageLoader loader = new StageLoader("CourseDetail.fxml");
                        loader.openStage(rowData.getKurs() + "-" + rowData.getRaum());
                        CourseDetailController.stage = loader.getStage();

                    });

                }
            });
            return row;
        });
    }

    public String getKursNameClick() {
        return kursNameClick;
    }

    public void setKursNameClick(String kursNameClick) {
        this.kursNameClick = kursNameClick;
    }

    public TableView getKursTable() {
        return kursTable;
    }

    public void setButtonsUsage(boolean use){

        setButtonUsage(btn_delKurs, use);
        setButtonUsage(btn_editKurs, use);

    }

}
