package bbcag.projekt.ui;

import bbcag.projekt.Game;
import bbcag.projekt.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DealUI extends BorderPane {

    ObservableList<Player> options;
    ComboBox dealer2Selection;

    public DealUI() {
        HBox dealScreenHBox = new HBox();

        //Left deal side
        TextField dealer1MoneyText = new TextField();
        ScrollPane dealer1PropertyScroll = new ScrollPane();
        Label dealer1FullMoneyLabel = new Label();
        TextField dealer1PropertyText = new TextField();
        dealer1PropertyScroll.setContent(dealer1FullMoneyLabel);

        VBox traderBox1 = new VBox(5);
        traderBox1.setPadding(new Insets(20));
        traderBox1.getChildren().addAll(dealer1MoneyText, dealer1PropertyScroll, dealer1FullMoneyLabel, dealer1PropertyText);

        //Right deal side

        options =
                FXCollections.observableArrayList();
        options.addAll(Game.getInstance().getPlayerList());

        dealer2Selection = new ComboBox(options);
        TextField dealer2MoneyText = new TextField();
        ScrollPane dealer2PropertyScroll = new ScrollPane();
        Label dealer2FullMoneyLabel = new Label();
        TextField dealer2PropertyText = new TextField();
        dealer2PropertyScroll.setContent(dealer2FullMoneyLabel);


        VBox traderBox2 = new VBox(5);
        traderBox2.setPadding(new Insets(20));
        traderBox2.getChildren().addAll(dealer2Selection, dealer2MoneyText, dealer2PropertyScroll, dealer2FullMoneyLabel, dealer2PropertyText);


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
        if(dealer2Selection.getValue().getClass().equals(Player.class)) {
            Player player = (Player) dealer2Selection.getValue();
            Game.getInstance().onDeal(player,);


            Game.getInstance().onDone();
        }
    }

    public void update(){
        options.addAll(Game.getInstance().getPlayerList());
        dealer2Selection = new ComboBox(options);
    }
}
