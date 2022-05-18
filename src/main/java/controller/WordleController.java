package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class WordleController {

    private int actual = 0;

    @FXML
    private GridPane grid;

    @FXML
    private Text word11;
    private Text word12;
    private Text word13;
    private Text word14;
    private Text word15;
    private Text word21;
    private Text word22;
    private Text word23;
    private Text word24;
    private Text word25;
    private Text word31;
    private Text word32;
    private Text word33;
    private Text word34;
    private Text word35;
    private Text word41;
    private Text word42;
    private Text word43;
    private Text word44;
    private Text word45;
    private Text word51;
    private Text word52;
    private Text word53;
    private Text word54;
    private Text word55;
    private Text word61;
    private Text word62;
    private Text word63;
    private Text word64;
    private Text word65;

    @FXML
    public void initialize() {

    }

    public void calculate(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        if (button.getId().equals("but_Q")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("Q");
        } else if (button.getId().equals("but_W")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("W");
        } else if (button.getId().equals("but_E")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("E");
        } else if (button.getId().equals("but_R")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("R");
        } else if (button.getId().equals("but_T")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("T");
        } else if (button.getId().equals("but_Y")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("Y");
        } else if (button.getId().equals("but_U")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("U");
        } else if (button.getId().equals("but_I")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("I");
        } else if (button.getId().equals("but_O")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("O");
        } else if (button.getId().equals("but_P")) {
            Text txt = (Text) grid.getChildren().get(actual);
            txt.setText("P");
        }


            actual++;
    }

    public void backspace(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        Text txt = (Text) grid.getChildren().get(actual-1);
        txt.setText(" ");
        if (actual > 0) {
            actual--;
        }

    }



}
