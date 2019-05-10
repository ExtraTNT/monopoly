package bbcag.projekt.ui;

import bbcag.projekt.Game;
import bbcag.projekt.field.NormalField;
import javafx.geometry.Insets;
import javafx.scene.control.*;
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
        Button hotelUIDone = new Button("Done");
        TextArea scrollText = new TextArea();

        VBox leftArea = new VBox(5);
        leftArea.setPadding(new Insets(20));
        leftArea.getChildren().addAll(chosenField,chosenFieldBuiltHouses, hotelUIPlusButton,hotelUIMinusButton,hotelUIDone);

        setPadding(new Insets(20));
        getChildren().addAll(buildableFields,leftArea);




        for(NormalField nf: Game.getInstance().getListOfMyHousableFields()) {
            scrollText.appendText(nf.getName() + " " + nf.getHotel());
            buildableFields.setContent(scrollText);
        }


        hotelUIPlusButton.setOnAction(event -> Game.getInstance().buildHouse((NormalField) Game.getInstance().getBoard().getFieldByName(chosenField.getText())));
        hotelUIMinusButton.setOnAction(event -> Game.getInstance().removeHotel((NormalField) Game.getInstance().getBoard().getFieldByName(chosenField.getText())));




    }
}
