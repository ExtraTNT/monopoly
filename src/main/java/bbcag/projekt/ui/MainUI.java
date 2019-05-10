package bbcag.projekt.ui;

import bbcag.projekt.*;
import bbcag.projekt.field.Field;
import bbcag.projekt.field.NormalField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class MainUI extends BorderPane {

    private static Label rollResult = new Label("_ and _");
    private Canvas centerAreaCanvas = new Canvas(900,900);
    private GraphicsContext gc = centerAreaCanvas.getGraphicsContext2D();
    public MainUI() {


        //Gameboard stuff
        ImageView gameBoard = new ImageView("SWISS.png");

        gameBoard.setFitHeight(900);
        gameBoard.setFitWidth(900);




        //gc.setFill(Paint.valueOf("#ff0000"));
        //gc.fillOval(500,810,40,40);
        StackPane centralStack = new StackPane();
        centralStack.getChildren().addAll(gameBoard,centerAreaCanvas);

        //Button stuff at the bottom
        Button rollButton = new Button("Roll");
        Button dealButton = new Button("Deal");
        Button buyButton = new Button("Buy");
        Button houseButton = new Button("Houses");
        Button turnButton = new Button("End Turn");

        HBox buttonArea = new HBox(20);
        buttonArea.getChildren().addAll(rollButton, dealButton, buyButton, houseButton, turnButton);

        rollButton.setPrefSize(180, 50);
        dealButton.setPrefSize(180, 50);
        buyButton.setPrefSize(180, 50);
        houseButton.setPrefSize(180, 50);
        turnButton.setPrefSize(180, 50);

        buttonArea.setPadding(new Insets(20));
        //Text and info stuff on the right

        VBox rightInfoArea = new VBox(3);

        TextField playerAccountBalanceField = new TextField();
        TextField playerPlayerNameField = new TextField();

        playerAccountBalanceField.setEditable(false);
        playerPlayerNameField.setEditable(false);

        ScrollPane playerPropertyScroll = new ScrollPane();
        TextArea playerPlaces = new TextArea();
        playerPlaces.setEditable(false);
        playerPropertyScroll.setContent(playerPlaces);



        TextField playerPlaceField = new TextField();
        playerPlaceField.setPrefWidth(200);

        ScrollPane playerAdditionalScroll = new ScrollPane();
        playerAdditionalScroll.setContent(rollResult);


        rightInfoArea.getChildren().addAll(playerAccountBalanceField, playerPlayerNameField, playerPropertyScroll, playerPlaceField, playerAdditionalScroll);

        rightInfoArea.setPadding(new Insets(20));


        //Left area space info
        VBox leftInfoArea = new VBox(3);

        ScrollPane spacePropertyScroll = new ScrollPane();


        rollResult.setPrefHeight(50);
        rollResult.setPrefWidth(100);

        rollButton.setOnAction(event -> Game.getInstance().rollDiceForCurrentPlayer());
        turnButton.setOnAction(event -> Game.getInstance().nextPlayer());
        dealButton.setOnAction(event -> Game.getInstance().startDealing());
        buyButton.setOnAction(event -> Game.getInstance().buyField());

        setCenter(centralStack);
        centerAreaCanvas.toFront();
        setBottom(buttonArea);
        setRight(rightInfoArea);


        //Game listeners
        Game.getInstance().addListener(new GameListener() {
            @Override
            public void onStart() {
                updatePlayerPositions();
            }

            @Override
            public void onPlayerAdded(Player player) {
                updatePlayerPositions();
            }

            @Override
            public void onCurrentPlayerChange(Player player) {
                playerAccountBalanceField.setText(player.getAccountBalance() + " €");
                playerPlayerNameField.setText(player.getName());
                updatePlayerPositions();
                playerPlaceField.setText(Game.getInstance().getBoard().getFieldByIndex(player.getPosition()).getName());
                playerPlaces.setText("");
                for(Field field : Game.getInstance().getBoard().getFieldsByOwner(player)){
                    playerPlaces.appendText(field.getName() + "\n");
                }
                //rollResult.setText(Game.getInstance().getPlayerList().get(1).getPosition() + " " + Game.getInstance().getPlayerList().get(1).getName());
            }

            @Override
            public void onDicesRolled(int dice1, int dice2) {
                rollResult.setText(dice1 + " and " + dice2);
                updatePlayerPositions();
                playerPlaceField.setText(Game.getInstance().getBoard().getFieldByIndex(Game.getInstance().getCurrentPlayer().getPosition()).getName());

            }

            @Override
            public void onStartDealing(Player currentPlayer) {

            }

            @Override
            public void onWin(Player winer) {
                gc.setFill(Paint.valueOf("#ff0000"));
                gc.fillText((winer + " WINS!"), 400, 200);
            }

            @Override
            public void onBuy(Player player) {
                playerAccountBalanceField.setText(player.getAccountBalance() + " €");
                playerPlaces.setText("");
                for(Field field : Game.getInstance().getBoard().getFieldsByOwner(player)){
                    playerPlaces.appendText(field.getName() + "\n");
                }
            }
        });
    }

    public String getRollResult() {
        return rollResult.getText();
    }

    public void setRollResult(String rollResult) {
        this.rollResult.setText(rollResult);
    }

    public void updatePlayerPositions (){
        gc.clearRect(0,0, 900, 900);
        for(Player p : Game.getInstance().getPlayerList()){
            gc.setFill(Paint.valueOf(p.getColor()));
            gc.fillOval(getPlayerX(p), getPlayerY(p), 40, 40);
        }
    }
    //Something Hugi made, function to find out the X position for a player
    private int getPlayerX(Player player){
        if(player.getPosition() >= 30 && player.getPosition() <= 39 || player.getPosition() == 0){
            return 810;
        }
        if(player.getPosition() >= 10 && player.getPosition() <= 20){
            return 50;
        }
        if(player.getPosition() >20 && player.getPosition() < 30){
            return((player.getPosition()-21)*72 + 140);
        }
        else{
            return (720- (player.getPosition()-1)*72);
        }
    }
    //Something Hugi made, function to find out the Y position for a player
    private int getPlayerY(Player player){
        if(player.getPosition() >= 0 && player.getPosition() <= 10){
            return 810;
        }
        if(player.getPosition() >= 20 && player.getPosition() <= 30){
            return 50;
        }
        if(player.getPosition() > 10 && player.getPosition() < 20){
            return (720- (player.getPosition()-11)*72);

        }
        else{
            return((player.getPosition()-31)*72 + 140);
        }
    }
}
