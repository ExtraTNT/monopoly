package bbcag.projekt.ui;

import bbcag.projekt.engine.Game;
import bbcag.projekt.engine.GameListener;
import bbcag.projekt.player.Player;
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

        scrollText.setEditable(false);

        VBox leftArea = new VBox(5);
        leftArea.setPadding(new Insets(20));
        leftArea.getChildren().addAll(chosenField,chosenFieldBuiltHouses, hotelUIPlusButton,hotelUIMinusButton,hotelUIDone);

        setPadding(new Insets(20));
        getChildren().addAll(buildableFields,leftArea);

        this.setMinSize(800,300);
        buildableFields.setMinSize(300,300);

        //Button actions for buying and selling houses
        hotelUIPlusButton.setOnAction(event -> {
            Game.getInstance().buildHouse((NormalField) Game.getInstance().getBoard().getFieldByName(chosenField.getText()));
            scrollText.setText("");
            for(NormalField nf: Game.getInstance().getListOfMyHousableFields()) {
                scrollText.appendText(nf.getName() + " -Houses: " + nf.getHotel() + " -Cost: " + nf.getWorthHotel() + "\n");
                buildableFields.setContent(scrollText);
            }
        });
        hotelUIMinusButton.setOnAction(event -> {
            Game.getInstance().removeHotel((NormalField) Game.getInstance().getBoard().getFieldByName(chosenField.getText()));
            scrollText.setText("");
            for(NormalField nf: Game.getInstance().getListOfMyHousableFields()) {
                scrollText.appendText(nf.getName() + " -Houses: " + nf.getHotel() + " -Cost: " + nf.getWorthHotel() + "\n");
                buildableFields.setContent(scrollText);
            }
        });
        hotelUIDone.setOnAction(event -> Game.getInstance().onDone());


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
                    scrollText.appendText(nf.getName() + " -Houses: " + nf.getHotel() + " -Cost: " + nf.getWorthHotel() + "\n" );
                    buildableFields.setContent(scrollText);
                }
            }

            @Override
            public void onDone() {

            }

            @Override
            public void onMessage(String message) {

            }
        });


    }
}
