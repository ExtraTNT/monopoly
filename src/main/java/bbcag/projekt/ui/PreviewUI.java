package bbcag.projekt.ui;

import bbcag.projekt.config.Configuration;
import bbcag.projekt.engine.Game;
import bbcag.projekt.engine.GameListener;
import bbcag.projekt.field.Field;
import bbcag.projekt.field.NormalField;
import bbcag.projekt.field.RailwayField;
import bbcag.projekt.field.WorkField;
import bbcag.projekt.player.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PreviewUI extends BorderPane {

    Label worth;
    TextArea rent;
    Label costHouse;
    public PreviewUI(){

        worth = new Label();
        costHouse = new Label();
        rent = new TextArea();
        rent.setEditable(false);
        rent.setPrefSize(180, 200);
        rent.setMaxSize(180, 200);

        worth.setText("Test");
        costHouse.setText("Test");

        worth.setPrefHeight(100);
        worth.setAlignment(Pos.CENTER);
        costHouse.setAlignment(Pos.BOTTOM_CENTER);

        ObservableList<Field> optionsFields = FXCollections.observableArrayList();

        ComboBox CBFields = new ComboBox(optionsFields);
        CBFields.setPrefSize(180, 50);

        VBox textFrame = new VBox();
        ImageView cardImageView = new ImageView("Card" + Configuration.getInstance().get("card.type") + ".png");
        cardImageView.setFitHeight(512);
        cardImageView.setFitWidth(256);
        StackPane centralStack = new StackPane();

        textFrame.setAlignment(Pos.TOP_CENTER);
        textFrame.getChildren().addAll(CBFields, worth, rent, costHouse);

        centralStack.getChildren().addAll(cardImageView, textFrame);

        Button PreviewUIDone = new Button("Done");
        PreviewUIDone.setPrefSize(180, 50);
        PreviewUIDone.setOnAction(event -> Game.getInstance().onDone());

        CBFields.setOnAction(event -> update((Field) CBFields.getValue()));

        setAlignment(PreviewUIDone, Pos.CENTER);
        setCenter(centralStack);
        setBottom(PreviewUIDone);

        Game.getInstance().addListener(new GameListener() {

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
            }
            @Override
            public void onDone() {
                worth.setText("");
                rent.setText("");
                costHouse.setText("");
            }
            @Override
            public void onMessage(String message) {
            }
            @Override
            public void onCardShow() {
                optionsFields.setAll(Game.getInstance().getFieldsCurrentPlayer());
            }
        });
    }

    private void update(Field field) {
        String rentStr = "";
        String worthStr = "";
        String houseStr = "";

        if(field.getClass() == NormalField.class){
            worthStr = field.getWorth() + "$";
            houseStr = "Kosten Haus / Hotel " + ((NormalField) field).getWorthHotel() + "$";
            int count = 0;
            for(int i : ((NormalField) field).getRentList()){
                if (count == 5){
                    rentStr += "Hotel: " + i + "$";
                } else if (count == 0) {
                    rentStr += "Ohne Etwas: " + i + "$\n";
                } else {
                    rentStr += count + " Haus: " + i + "$\n";
                }
                count ++;
            }
        } else if(field.getClass() == RailwayField.class){
            worthStr = field.getWorth() + "$";
            houseStr = "";
            int count = 0;
            for(int i : ((RailwayField) field).getRentList()){
                count ++;
                rentStr += count + " Feld: " + i + "$\n";
            }
        } else if(field.getClass() == WorkField.class){
            worthStr = field.getWorth() + "$";
            houseStr = "";
            rentStr = "1 Feld: Die gewuerfelte Summe mal 4\n2 Felder: Die gewuerfelte Summe mal 11";
        }
        rent.setText(rentStr);
        worth.setText(worthStr);
        costHouse.setText(houseStr);
    }
}
