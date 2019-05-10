package bbcag.projekt.ui;

import bbcag.projekt.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WinnerUI extends BorderPane {
    public WinnerUI() {
        VBox winnerBox = new VBox();
        this.setMinSize(200,200);

        winnerBox.setAlignment(Pos.BASELINE_CENTER);

        Label winLabel = new Label("Game Over!");
        winLabel.setFont(new Font(50));
        Button winButton = new Button("Exit");
        winButton.setPrefSize(200,100);

        winnerBox.getChildren().addAll(winLabel,winButton);
        this.setCenter(winnerBox);

        //Clicking this button makes you exit
        winButton.setOnAction(event -> System.exit(0));

    }

}
