package bbcag.projekt.ui;

import bbcag.projekt.Game;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WinnerUI extends VBox {
    public WinnerUI() {

        setHeight(500);
        setWidth(500);


        Label winLabel = new Label(Game.getInstance().getCurrentPlayer() + " WINS!");
        Button winButton = new Button("Exit");

        setPadding(new Insets(20));
        getChildren().addAll(winLabel,winButton);

        winButton.setOnAction(event -> System.exit(0));

    }

}
