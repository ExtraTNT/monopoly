package bbcag.projekt.ui;

import bbcag.projekt.engine.Game;
import bbcag.projekt.player.Player;
import bbcag.projekt.field.Field;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DealUI extends BorderPane {

    private ObservableList<Player> options;
    private ObservableList<Field> optionsFieldsPlayer1;
    private ObservableList<Field> optionsFieldsPlayer2;
    private ComboBox dealer1Field;
    private ComboBox dealer2Field;
    private ComboBox dealer2Selection;
    private TextField dealer2MoneyText;
    private TextField dealer1MoneyText;

    public DealUI() {
        HBox dealScreenHBox = new HBox();

        //Left deal side

        optionsFieldsPlayer1 =
                FXCollections.observableArrayList();
        dealer1Field = new ComboBox(optionsFieldsPlayer1);
        dealer1MoneyText = new TextField();
        ScrollPane dealer1PropertyScroll = new ScrollPane();
        Label dealer1FullMoneyLabel = new Label();
        dealer1PropertyScroll.setContent(dealer1FullMoneyLabel);

        VBox traderBox1 = new VBox(5);
        traderBox1.setPadding(new Insets(20));
        traderBox1.getChildren().addAll(dealer1MoneyText, dealer1PropertyScroll, dealer1FullMoneyLabel, dealer1Field);

        //Right deal side

        options =
                FXCollections.observableArrayList();
        options.addAll(Game.getInstance().getPlayerList());

        dealer2Selection = new ComboBox(options);

        dealer2Selection.setOnAction(event -> update(false));

        optionsFieldsPlayer2 =
                FXCollections.observableArrayList();
        dealer2Field = new ComboBox(optionsFieldsPlayer2);

        dealer2MoneyText = new TextField();
        ScrollPane dealer2PropertyScroll = new ScrollPane();
        Label dealer2FullMoneyLabel = new Label();
        TextField dealer2PropertyText = new TextField();
        dealer2PropertyScroll.setContent(dealer2FullMoneyLabel);


        VBox traderBox2 = new VBox(5);
        traderBox2.setPadding(new Insets(20));
        traderBox2.getChildren().addAll(dealer2Selection, dealer2MoneyText, dealer2PropertyScroll, dealer2FullMoneyLabel, dealer2Field);


        //dealScreen bottom area
        Button dealDealButton = new Button("Deal");
        Button dealExitButton = new Button("Exit");

        //dealExitButton.setOnAction(event -> primaryStage.setScene(mainScene));
        dealExitButton.setOnAction(event -> Game.getInstance().onDone());
        dealDealButton.setOnAction(event -> onDealPressed());



        HBox dealBottomArea = new HBox(5);
        dealBottomArea.setPadding(new Insets(10));

        dealBottomArea.getChildren().addAll(dealDealButton, dealExitButton);
        dealScreenHBox.getChildren().addAll(traderBox1, traderBox2);
        setCenter(dealScreenHBox);
        setBottom(dealBottomArea);
    }
    private void onDealPressed() {
            Player player = (Player) dealer2Selection.getValue();
            int money1;
            int money2;

            if(!dealer1MoneyText.getText().equals("") || !dealer1MoneyText.getText().isEmpty()){
                money1 =  Integer.parseInt(dealer1MoneyText.getText()); //exception here NumberFormatException -> string is ""
            } else{money1 = 0;
            }
            if(!dealer2MoneyText.getText().equals("") || !dealer1MoneyText.getText().isEmpty()) {
                money2 = Integer.parseInt(dealer2MoneyText.getText()); //exception here NumberFormatException
            } else{money2 = 0;
            }


            Game.getInstance().onDeal(player, money1, money2, (Field)dealer1Field.getValue(), (Field)dealer2Field.getValue());

            Game.getInstance().onDone();
    }
    public void update(boolean optionsupdate){
        if(optionsupdate) {
            options.setAll(Game.getInstance().getPlayerList());
        }

        optionsFieldsPlayer1.setAll(Game.getInstance().getFieldsCurrentPlayer());

        optionsFieldsPlayer2.setAll(Game.getInstance().getBoard().getFieldsByOwner((Player)dealer2Selection.getValue()));

        dealer2Selection = new ComboBox(options);
        dealer1Field = new ComboBox(optionsFieldsPlayer1);
    }
}

//todo fix (update, onDealPressed) -> nullpointer with fields and player, ""!= ""
