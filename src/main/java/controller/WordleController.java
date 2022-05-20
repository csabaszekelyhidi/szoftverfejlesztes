package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Wordle;

import java.io.IOException;
import java.util.ArrayList;

public class WordleController {

    private Wordle game;
    private int actual = 0;
    private int currentStart = 0;

    private boolean locked = false;

    private ArrayList<Button> usedButtons = new ArrayList<Button>();
    private ArrayList<String> usedChars = new ArrayList<String>();

    @FXML
    private GridPane grid;

    @FXML
    private Label labeltochange;

    @FXML
    public void initialize() {
        this.game = new Wordle();
    }

    public void charPressed(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        if ( actual < currentStart +5 ) {
            Label txt = (Label) grid.getChildren().get(actual);
            txt.setText(button.getText());
            usedButtons.add(button);
            actual++;
        }
    }

    public void backspace(ActionEvent actionEvent) {

        if (actual > currentStart && actual <= currentStart +5) {
            Label txt = (Label) grid.getChildren().get(actual-1);
            txt.setText("");
            actual--;
            if (!usedChars.contains(usedButtons.get(usedButtons.size()-1).getText()) )
            {
                usedButtons.remove(usedButtons.size()-1);
            }

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
                usedChars.add(characters[i].getText());
                wordguess = wordguess+characters[i].getText();
            }

            for (int i = 0; i< usedButtons.size(); i++) {
                usedButtons.get(i).setStyle("-fx-background-color: #8F8F8F;");
            }

            //System.out.println(wordguess);

            currentStart = currentStart + 5;

            if (word.matches(wordguess)) {
                System.out.println("SIKERES");
                try {
                    switchToResults(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public void switchToResults(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Results.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<ResultsController>getController().initdata("ALMAF");
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }



}
