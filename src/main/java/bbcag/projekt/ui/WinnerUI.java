package bbcag.projekt.ui;

import bbcag.projekt.Game;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class WinnerUI extends BorderPane {
    public WinnerUI() {
        VBox winnerBox = new VBox();
        this.setMinSize(150,150);


        Label winLabel = new Label(" You Win!");
        Button winButton = new Button("Exit");

        winnerBox.getChildren().addAll(winLabel,winButton);
        this.setCenter(winnerBox);

        //Clicking this button makes you exit
        winButton.setOnAction(event -> System.exit(0));

    }

}
