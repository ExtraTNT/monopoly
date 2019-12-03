package bbcag.projekt.ui;

import bbcag.projekt.config.Configuration;
import bbcag.projekt.engine.Game;
import bbcag.projekt.engine.GameListener;
import bbcag.projekt.player.Player;
import bbcag.projekt.field.Field;
import bbcag.projekt.field.NormalField;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class MainUI extends BorderPane {

    private static Label rollResult = new Label("_ and _");
    private Canvas centerAreaCanvas = new Canvas(900, 900);
    private GraphicsContext gc = centerAreaCanvas.getGraphicsContext2D();

    public MainUI() {

        //Gameboard stuff
        ImageView gameBoard = new ImageView(Configuration.getInstance().get("board.type") + ".png");
        gameBoard.setFitHeight(900);
        gameBoard.setFitWidth(900);
        StackPane centralStack = new StackPane(); //Stackpane to stack both the gameBoard and Canvas on top of each other
        centralStack.getChildren().addAll(gameBoard, centerAreaCanvas);

        //Button stuff at the bottom
        Button rollButton = new Button("Roll");
        Button dealButton = new Button("Deal");
        Button buyButton = new Button("Buy");
        Button houseButton = new Button("Houses");
        Button turnButton = new Button("End Turn");
        Button cardButton = new Button("Show Fields");

        HBox buttonArea = new HBox(20);
        buttonArea.getChildren().addAll(rollButton, dealButton, buyButton, houseButton, cardButton, turnButton);


        rollButton.setPrefSize(180, 50);
        dealButton.setPrefSize(180, 50);
        buyButton.setPrefSize(180, 50);
        houseButton.setPrefSize(180, 50);
        turnButton.setPrefSize(180, 50);
        cardButton.setPrefSize(180, 50);

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
        playerPlaceField.setEditable(false);

        ScrollPane playerAdditionalScroll = new ScrollPane();
        playerAdditionalScroll.setContent(rollResult);

        TextArea gameMessages = new TextArea();
        gameMessages.setEditable(false);

        rightInfoArea.getChildren().addAll(playerAccountBalanceField, playerPlayerNameField, playerPropertyScroll, playerPlaceField, playerAdditionalScroll, gameMessages);
        rightInfoArea.setPadding(new Insets(20));

        //Left area space info

        rollResult.setPrefHeight(50);
        rollResult.setPrefWidth(100);

        rollButton.setOnAction(event -> Game.getInstance().rollDiceForCurrentPlayer());
        turnButton.setOnAction(event -> Game.getInstance().nextPlayer());
        dealButton.setOnAction(event -> Game.getInstance().startDealing());
        houseButton.setOnAction(event -> Game.getInstance().onHotel());
        buyButton.setOnAction(event -> Game.getInstance().buyField());
        cardButton.setOnAction(event -> Game.getInstance().onCardShow());

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
                playerAccountBalanceField.setText(player.getAccountBalance() + ".-");
                playerPlayerNameField.setText(player.getName());
                updatePlayerPositions();
                playerPlaceField.setText(Game.getInstance().getBoard().getFieldByIndex(player.getPosition()).getName());
                playerPlaces.setText("");
                for (Field field : Game.getInstance().getBoard().getFieldsByOwner(player)) {
                    playerPlaces.appendText(field.getName() + "\n");
                }
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
                playerAccountBalanceField.setText(player.getAccountBalance() + ".-");
                playerPlaces.setText("");
                for (Field field : Game.getInstance().getBoard().getFieldsByOwner(player)) {
                    playerPlaces.appendText(field.getName() + "\n");
                }
                updatePlayerPositions();
            }

            @Override
            public void onHotel() {
                updatePlayerPositions();
            }

            @Override
            public void onDone() {
            }

            @Override
            public void onMessage(String message) {
                gameMessages.appendText(message + "\n");
            }

            @Override
            public void onCardShow() {
            }
        });
    }

    private void updatePlayerPositions() {
        gc.clearRect(0, 0, 900, 900);
        for (Player p : Game.getInstance().getPlayerList()) {
            gc.setFill(Paint.valueOf(p.getColor()));
            gc.fillOval(getPlayerX(p), getPlayerY(p), 40, 40);
        }
        updateHotels();
    }

    /**
     * getPlayerX
     * calculate the x pos, that the player can be drawn on the screen
     *
     * @param player the player object
     * @return X-position to draw the player at
     */
    private int getPlayerX(Player player) {
        if (player.getPosition() >= 30 && player.getPosition() <= 39 || player.getPosition() == 0) {
            return 810;
        }
        if (player.getPosition() >= 10 && player.getPosition() <= 20) {
            return 50;
        }
        if (player.getPosition() > 20 && player.getPosition() < 30) {
            return ((player.getPosition() - 21) * 72 + 140);
        } else {
            return (720 - (player.getPosition() - 1) * 72);
        }
    }

    /**
     * getPlayerY
     * calculate the y pos, that the player can be drawn on the screen
     *
     * @param player the player object
     * @return y-position to draw the player at
     */
    private int getPlayerY(Player player) {
        if (player.getPosition() >= 0 && player.getPosition() <= 10) {
            return 810;
        }
        if (player.getPosition() >= 20 && player.getPosition() <= 30) {
            return 50;
        }
        if (player.getPosition() > 10 && player.getPosition() < 20) {
            return (720 - (player.getPosition() - 11) * 72);
        } else {
            return ((player.getPosition() - 31) * 72 + 140);
        }
    }

    private void updateHotels() {

        for (NormalField field : Game.getInstance().getListHousableFields()) {
            if (field.getOwner() != Game.getInstance().getBank() && field.getOwner() != null) {
                gc.setFill(Paint.valueOf(field.getOwner().getColor()));
                gc.fillText(field.getHotel() + "", getHotelX(field), getHotelY(field));
            }
        }
    }

    private int getHotelY(Field field) {
        if (Game.getInstance().getBoard().getIndexFromField(field) >= 0 &&
                Game.getInstance().getBoard().getIndexFromField(field) <= 10) {
            return 790;
        }
        if (Game.getInstance().getBoard().getIndexFromField(field) >= 20 &&
                Game.getInstance().getBoard().getIndexFromField(field) <= 30) {
            return 120;
        }
        if (Game.getInstance().getBoard().getIndexFromField(field) > 10 &&
                Game.getInstance().getBoard().getIndexFromField(field) < 20) {
            return (720 - (Game.getInstance().getBoard().getIndexFromField(field) - 11) * 72);
        } else {
            return ((Game.getInstance().getBoard().getIndexFromField(field) - 31) * 72 + 140);
        }
    }

    private int getHotelX(Field field) {
        if (Game.getInstance().getBoard().getIndexFromField(field) >= 30 &&
                Game.getInstance().getBoard().getIndexFromField(field) <= 39 ||
                Game.getInstance().getBoard().getIndexFromField(field) == 0) {
            return 780;
        }
        if (Game.getInstance().getBoard().getIndexFromField(field) >= 10 &&
                Game.getInstance().getBoard().getIndexFromField(field) <= 20) {
            return 105;
        }
        if (Game.getInstance().getBoard().getIndexFromField(field) > 20 &&
                Game.getInstance().getBoard().getIndexFromField(field) < 30) {
            return ((Game.getInstance().getBoard().getIndexFromField(field) - 21) * 72 + 140);
        } else {
            return (720 - (Game.getInstance().getBoard().getIndexFromField(field) - 1) * 72);
        }
    }
}
