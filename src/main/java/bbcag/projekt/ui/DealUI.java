package bbcag.projekt.ui;

import bbcag.projekt.engine.Game;
import bbcag.projekt.engine.GameListener;
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
    private TextField dealer1Name;
    private Label dealer1FullMoneyLabel;
    private Label dealer2FullMoneyLabel;

    /**DealUI
     * The UI, to deal with other player (Money and Fields)
     */
    public DealUI() {
        HBox dealScreenHBox = new HBox();

        //Left deal side
        optionsFieldsPlayer1 = FXCollections.observableArrayList();
        dealer1Field = new ComboBox(optionsFieldsPlayer1);
        dealer1MoneyText = new TextField();
        dealer1Name = new TextField();
        dealer1Name.setEditable(false);
        ScrollPane dealer1PropertyScroll = new ScrollPane();
        dealer1FullMoneyLabel = new Label();
        dealer1PropertyScroll.setContent(dealer1FullMoneyLabel);

        VBox traderBox1 = new VBox(5);
        traderBox1.setPadding(new Insets(20));
        traderBox1.getChildren().addAll(dealer1Name, dealer1MoneyText, dealer1PropertyScroll, dealer1FullMoneyLabel, dealer1Field);

        //Right deal side
        options = FXCollections.observableArrayList();
        options.addAll(Game.getInstance().getPlayerList());
        dealer2Selection = new ComboBox(options);

        /**dealer2Selection.setOnAction(event -> update());
         * this method provoke exceptions, but doesn't cause any other problems
         * the old method resulted in a failure of the garbage collector xD
         */
        dealer2Selection.setOnAction(event -> update()); // -> update (p2 just 4 testing)

        optionsFieldsPlayer2 = FXCollections.observableArrayList();
        dealer2Field = new ComboBox(optionsFieldsPlayer2);
        dealer2MoneyText = new TextField();
        ScrollPane dealer2PropertyScroll = new ScrollPane();
        dealer2FullMoneyLabel = new Label();
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

        Game.getInstance().addListener(new GameListener(){
            @Override
            public void onStart() {}
            @Override
            public void onPlayerAdded(Player player) {}
            @Override
            public void onCurrentPlayerChange(Player player) {}
            @Override
            public void onDicesRolled(int dice1, int dice2) {}
            @Override
            public void onStartDealing(Player currentPlayer) {
                dealer1Name.setText(Game.getInstance().getCurrentPlayer().toString());
                options.setAll(Game.getInstance().getPlayerList());
                dealer1FullMoneyLabel.setText(Game.getInstance().getCurrentPlayer().getAccountBalance() + "$");
                optionsFieldsPlayer1.setAll(Game.getInstance().getFieldsCurrentPlayer());
            }
            @Override
            public void onWin(Player winer) {}
            @Override
            public void onBuy(Player player) {}
            @Override
            public void onHotel() {}
            @Override
            public void onDone() {}
            @Override
            public void onMessage(String message) {}
            @Override
            public void onCardShow() {}

            @Override
            public void onAlert(String message) {

            }
        });
    }
    /**onDealPressed
     * check, if the players have given a number as money-value (if not, 0 will be used) and calls the onDeal method on the Game
     * after that, it calls the onDone method -> back to the mainUI
     */
    private void onDealPressed() {
            Player player = (Player) dealer2Selection.getValue();
            int money1;
            int money2;

            if(!dealer1MoneyText.getText().equals("") && !dealer1MoneyText.getText().isEmpty()){ money1 = Integer.parseInt(dealer1MoneyText.getText());}
            else{money1 = 0;}
            if(!dealer2MoneyText.getText().equals("") && !dealer2MoneyText.getText().isEmpty()){ money2 = Integer.parseInt(dealer2MoneyText.getText());}
            else{money2 = 0;}

            Game.getInstance().onDeal(player, money1, money2, (Field)dealer1Field.getValue(), (Field)dealer2Field.getValue());
            Game.getInstance().onDone();
    }
    private void update(){
            optionsFieldsPlayer2.setAll(Game.getInstance().getBoard().getFieldsByOwner((Player) dealer2Selection.getValue()));
            dealer2FullMoneyLabel.setText(((Player) dealer2Selection.getValue()).getAccountBalance() + "$");
    }
}