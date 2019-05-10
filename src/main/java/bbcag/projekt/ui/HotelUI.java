package bbcag.projekt.ui;

import bbcag.projekt.Game;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HotelUI  extends HBox {
    public HotelUI() {
        //Different fields
        ScrollPane buildableFields = new ScrollPane();
        TextField chosenField = new TextField();
        Label chosenFieldBuiltHouses = new Label();
        Button hotelUIPlusButton = new Button("+");
        Button hotelUIMinusButton = new Button("-");

        VBox leftArea = new VBox(5);
        leftArea.setPadding(new Insets(20));
        leftArea.getChildren().addAll(chosenField,chosenFieldBuiltHouses, hotelUIPlusButton,hotelUIMinusButton);

        setPadding(new Insets(20));
        getChildren().addAll(buildableFields,leftArea);


        hotelUIPlusButton.setOnAction(event -> Game.getInstance().buildHouse());

    }
}
