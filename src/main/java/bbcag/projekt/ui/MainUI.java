package bbcag.projekt.ui;

import bbcag.projekt.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainUI extends BorderPane {

    private static Label rollResult = new Label("_ and _");

    public MainUI() {


        //Gameboard stuff
        ImageView gameBoard = new ImageView("SWISS.png");
        gameBoard.setFitHeight(900);
        gameBoard.setFitWidth(900);


        //Button stuff at the bottom
        Button rollButton = new Button("Roll");
        Button dealButton = new Button("Deal");
        Button houseButton = new Button("Houses");
        Button turnButton = new Button("End Turn");

        HBox buttonArea = new HBox(20);
        buttonArea.getChildren().addAll(rollButton, dealButton, houseButton, turnButton);

        rollButton.setPrefSize(250, 50);
        dealButton.setPrefSize(250, 50);
        houseButton.setPrefSize(250, 50);
        turnButton.setPrefSize(250, 50);

        buttonArea.setPadding(new Insets(20));
        //Text and info stuff on the right

        VBox rightInfoArea = new VBox(3);

        TextField playerAccountBalanceField = new TextField();
        TextField playerPlayerNameField = new TextField();

        ScrollPane playerPropertyScroll = new ScrollPane();


        TextField playerJailcardField = new TextField();

        ScrollPane playerAdditionalScroll = new ScrollPane();
        playerAdditionalScroll.setContent(rollResult);


        rightInfoArea.getChildren().addAll(playerAccountBalanceField, playerPlayerNameField, playerPropertyScroll, playerJailcardField, playerAdditionalScroll);

        rightInfoArea.setPadding(new Insets(20));


        //Left area space info
        VBox leftInfoArea = new VBox(3);

        ScrollPane spacePropertyScroll = new ScrollPane();


        rollResult.setPrefHeight(50);
        rollResult.setPrefWidth(100);

        rollButton.setOnAction(event -> Game.getInstance().rollDiceForCurrentPlayer());
        turnButton.setOnAction(event -> Game.getInstance().nextPlayer());
        dealButton.setOnAction(event -> Game.getInstance().startDealing());

        setCenter(gameBoard);
        setBottom(buttonArea);
        setRight(rightInfoArea);

        Game.getInstance().addListener(new GameListener() {
            @Override
            public void onStart() {
            }

            @Override
            public void onPlayerAdded(Player player) {

            }

            @Override
            public void onCurrentPlayerChange(Player player) {
                playerAccountBalanceField.setText(player.getAccountBalance() + " €");
                playerPlayerNameField.setText(player.getName());
            }

            @Override
            public void onDicesRolled(int dice1, int dice2) {
                rollResult.setText(dice1 + " and " + dice2);
            }

            @Override
            public void onStartDealing(Player currentPlayer) {

            }
        });
    }

    public String getRollResult() {
        return rollResult.getText();
    }

    public void setRollResult(String rollResult) {
        this.rollResult.setText(rollResult);
    }
}
