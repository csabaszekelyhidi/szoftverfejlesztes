package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.Wordle;

public class WordleController {

    private Wordle game;
    private int actual = 0;
    private int currentStart = 0;

    private boolean locked = false;

    @FXML
    private GridPane grid;

    @FXML
    public void initialize() {
        this.game = new Wordle();
    }

    public void charPressed(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        if ( actual < currentStart +5 ) {
            Label txt = (Label) grid.getChildren().get(actual);
            txt.setText(button.getText());

            actual++;
        }
    }

    public void backspace(ActionEvent actionEvent) {

        if (actual > currentStart && actual <= currentStart +5) {
            Label txt = (Label) grid.getChildren().get(actual-1);
            txt.setText("");
            actual--;
        }
    }

    public void enterWord(ActionEvent actionEvent) {

        Label[] characters = new Label[5];
        String wordguess = "";
        String word = game.getWord();

        if (actual%5 == 0) {

            for (int i=0;i<5;i++) {
                characters[i] = (Label) grid.getChildren().get(currentStart + i);
                char cha = characters[i].getText().toCharArray()[0];
                if (game.isCharacterMatching(i,cha)) {
                    characters[i].setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                } else if (game.isContainsCharacter(cha)) {
                    characters[i].setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
                }
                wordguess = wordguess+characters[i].getText();
            }

            //System.out.println(wordguess);

            currentStart = currentStart + 5;
        }
    }

}
