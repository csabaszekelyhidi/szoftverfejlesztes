package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Result;
import model.ResultHandler;

import java.io.IOException;

public class ResultsController {

    @FXML
    private Label DB1, DB2, DB3, DB4, DB5, DB6, DBLOST;
    @FXML
    private ProgressBar PB1, PB2, PB3, PB4, PB5, PB6, PBLOST;
    @FXML
    private Text winmessage, streak;



    private String word;

    private ResultHandler result;

    @FXML
    public void initialize() {

    }

    public void initdata(String word, boolean win, int guess) {
        this.word = word;
        result = new ResultHandler(win, guess);

        DB1.setText(String.valueOf(result.getGuess1()));
        DB2.setText(String.valueOf(result.getGuess2()));
        DB3.setText(String.valueOf(result.getGuess3()));
        DB4.setText(String.valueOf(result.getGuess4()));
        DB5.setText(String.valueOf(result.getGuess5()));
        DB6.setText(String.valueOf(result.getGuess6()));
        DBLOST.setText(String.valueOf(result.getLostGamesCount()));

        PB1.setProgress(result.getProgress(1));
        PB2.setProgress(result.getProgress(2));
        PB3.setProgress(result.getProgress(3));
        PB4.setProgress(result.getProgress(4));
        PB5.setProgress(result.getProgress(5));
        PB6.setProgress(result.getProgress(6));
        PBLOST.setProgress(result.getProgress(7));

        if ( win ) { winmessage.setText("You won!   It was "+word); }
        else { winmessage.setText("You lost!   It was "+word); }

        streak.setText("CURRENT STREAK: "+String.valueOf(result.getStreak()));

    }

    public void newGame(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Wordle.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
