package bbcag.projekt.ui;

import bbcag.projekt.Game;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WinnerUI extends VBox {
    public WinnerUI() {

        this.setMinSize(300,200);


        Label winLabel = new Label(" You Win!");
        Button winButton = new Button("Exit");

        setPadding(new Insets(20));
        getChildren().addAll(winLabel,winButton);

        //Clicking this button makes you exit
        winButton.setOnAction(event -> System.exit(0));

    }

}
