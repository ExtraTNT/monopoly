package bbcag.projekt.ui;

import bbcag.projekt.Game;
import bbcag.projekt.GameListener;
import bbcag.projekt.Player;
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


        Game.getInstance().addListener(new GameListener(){

            @Override
            public void onStart() {

            }

            @Override
            public void onPlayerAdded(Player player) {

            }

            @Override
            public void onCurrentPlayerChange(Player player) {

            }

            @Override
            public void onDicesRolled(int dice1, int dice2) {

            }

            @Override
            public void onStartDealing(Player currentPlayer) {

            }

            @Override
            public void onWin(Player winer) {

            }

            @Override
            public void onBuy(Player player) {

            }

            @Override
            public void onHotel() {
                scrollText.setText("");
                for(NormalField nf: Game.getInstance().getListOfMyHousableFields()) {
                    scrollText.appendText(nf.getName() + " -Houses: " + nf.getHotel() + "\n");
                    buildableFields.setContent(scrollText);
                }
            }

            @Override
            public void onDone() {

            }
        });




        hotelUIPlusButton.setOnAction(event -> Game.getInstance().buildHouse((NormalField) Game.getInstance().getBoard().getFieldByName(chosenField.getText())));
        hotelUIMinusButton.setOnAction(event -> Game.getInstance().removeHotel((NormalField) Game.getInstance().getBoard().getFieldByName(chosenField.getText())));
        hotelUIDone.setOnAction(event -> Game.getInstance().onDone());



    }
}
