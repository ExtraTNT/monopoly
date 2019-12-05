package bbcag.projekt.ui;

import bbcag.projekt.config.Configuration;
import bbcag.projekt.engine.Game;
import bbcag.projekt.engine.GameListener;
import bbcag.projekt.field.*;
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
import java.util.List;

public class PreviewUI extends BorderPane {
    Label worth;
    TextArea rent;
    Label costHouse;
    ObservableList<Player> optionsPlayers = FXCollections.observableArrayList();
    ObservableList<Field> optionsFields = FXCollections.observableArrayList();
    ComboBox CBPlayers = new ComboBox(optionsPlayers);
    ComboBox CBFields = new ComboBox(optionsFields);
    public PreviewUI(){
        worth = new Label();
        worth.setPrefHeight(100); //used to make the rent (TextArea) fit in the box (if the picture (card) is made with the original grind)
        worth.setAlignment(Pos.CENTER);

        costHouse = new Label();
        costHouse.setAlignment(Pos.BOTTOM_CENTER);

        rent = new TextArea();
        rent.setEditable(false);
        rent.setPrefSize(180, 200);
        rent.setMaxSize(180, 200);

        CBFields.setPrefSize(180, 25);
        CBFields.setOnAction(event -> update((Field) CBFields.getValue()));

        CBPlayers.setPrefSize(180, 25);
        CBPlayers.setOnAction(event -> playerSelectUpdate());

        VBox textFrame = new VBox();
        textFrame.setAlignment(Pos.TOP_CENTER);
        textFrame.getChildren().addAll(CBFields, CBPlayers, worth, rent, costHouse);

        ImageView cardImageView = new ImageView("Card" + Configuration.getInstance().get("card.type") + ".png");
        cardImageView.setFitHeight(512);
        cardImageView.setFitWidth(256);

        StackPane centralStack = new StackPane();
        centralStack.getChildren().addAll(cardImageView, textFrame);

        Button PreviewUIDone = new Button("Done");
        PreviewUIDone.setPrefSize(180, 50);
        PreviewUIDone.setOnAction(event -> Game.getInstance().onDone());

        setAlignment(PreviewUIDone, Pos.CENTER);
        setCenter(centralStack);
        setBottom(PreviewUIDone);

        Game.getInstance().addListener(new GameListener() {
            @Override
            public void onStart() {}
            @Override
            public void onPlayerAdded(Player player) {}
            @Override
            public void onCurrentPlayerChange(Player player) {}
            @Override
            public void onDicesRolled(int dice1, int dice2) {}
            @Override
            public void onStartDealing(Player currentPlayer) {}
            @Override
            public void onWin(Player winer) {}
            @Override
            public void onBuy(Player player) {}
            @Override
            public void onHotel() {}
            @Override
            public void onDone() {
                worth.setText("");
                rent.setText("");
                costHouse.setText("");
            }
            @Override
            public void onMessage(String message) {}
            @Override
            public void onCardShow() {optionsPlayers.setAll(Game.getInstance().getPlayerList());}
        });
    }
    private void playerSelectUpdate() {
        rent.setText("");
        worth.setText("");
        costHouse.setText("");
        List<Field> fieldsSP = Game.getInstance().getBoard().getFieldsByOwner((Player) CBPlayers.getValue());
        optionsFields.setAll(fieldsSP);
        if (CBPlayers.getValue() == Game.getInstance().getCurrentPlayer()) {
            Field field = Game.getInstance().getBoard().getFieldByIndex(((Player) (CBPlayers.getValue())).getPosition());
            boolean br = false;
            for (Field f : fieldsSP) {
                if (f == field) {
                    br = true;
                    break;
                }
            }
            if (!br) optionsFields.add(field);
        }
    }
    private void update(Field field) {
        String rentStr = "";
        String worthStr = "";
        String houseStr = "";
        //doesn't work with switch because of type class
        if(field.getClass() == NormalField.class){
            worthStr = field.getWorth() + "$";
            houseStr = "Kosten Haus / Hotel " + ((NormalField) field).getWorthHotel() + "$";
            int count = 0;
            for(int i : ((NormalField) field).getRentList()){
                switch (count) {
                    case 5:
                        rentStr += "Hotel: " + i + "$";
                        break;
                    case 0:
                        rentStr += "Ohne Etwas: " + i + "$\n";
                        break;
                    default:
                        rentStr += count + " Haus: " + i + "$\n";
                        break;
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
        } else if(field.getClass() == StartField.class){
            rentStr = "Steping over: " + ((StartField) field).getStartMoney() + "$\n" +
                    "Stepping on: " + (((StartField) field).getStartMoney()*2) + "$" ;
        } else if(field.getClass() == JailField.class){
            rentStr = "Wuerfele 3 mal um Pach um frei zu kommen.\n" +
                    "sollte es dir nicht gelingen, so musst du 100$ zahlen";
        }
        rent.setText(rentStr);
        worth.setText(worthStr);
        costHouse.setText(houseStr);
    }
}