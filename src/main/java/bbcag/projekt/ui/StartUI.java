package bbcag.projekt.ui;

import bbcag.projekt.Game;
import bbcag.projekt.GameListener;
import bbcag.projekt.Player;
import bbcag.projekt.exception.NotEnoughPlayersException;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StartUI extends BorderPane {

    public StartUI() {

        //Center area
        VBox startCenterArea = new VBox(5);
        startCenterArea.setPadding(new Insets(20));
        Label startTitlePlayer = new Label("Player");
        TextField startPlayerEntry = new TextField();
        Label startTitleFigure = new Label("Figures");

        ToggleGroup startRadioGroup = new ToggleGroup();

        RadioButton startFigureRed = new RadioButton("Red");
        startFigureRed.setUserData("#FF0000");
        startFigureRed.setToggleGroup(startRadioGroup);

        RadioButton startFigureBlue = new RadioButton("Blue");
        startFigureBlue.setUserData("#0000FF");
        startFigureBlue.setToggleGroup(startRadioGroup);

        RadioButton startFigureGreen = new RadioButton("Green");
        startFigureGreen.setUserData("#008000");
        startFigureGreen.setToggleGroup(startRadioGroup);

        RadioButton startFigureWhite = new RadioButton("White");
        startFigureWhite.setUserData("#FFFFFF");
        startFigureWhite.setToggleGroup(startRadioGroup);

        RadioButton startFigureYellow = new RadioButton("Yellow");
        startFigureYellow.setUserData("#FFFF00");
        startFigureYellow.setToggleGroup(startRadioGroup);

        RadioButton startFigureBlack = new RadioButton("Black");
        startFigureBlack.setUserData("#000000");
        startFigureBlack.setToggleGroup(startRadioGroup);

        startCenterArea.getChildren().addAll(
                startTitlePlayer, startPlayerEntry,
                startTitleFigure, startFigureRed, startFigureBlue,
                startFigureGreen, startFigureWhite, startFigureYellow,
                startFigureBlack);

        //Bottom area
        HBox startBottomArea = new HBox(5);
        startBottomArea.setPadding(new Insets(20));
        Button startCreateButton = new Button("Create");
        Button startDoneButton = new Button("Done");
        startBottomArea.getChildren().addAll(startCreateButton, startDoneButton);

        //Right area
        TextArea startPlayerListText = new TextArea();
        startPlayerListText.setEditable(false);

        // Add to layout
        setCenter(startCenterArea);
        setRight(startPlayerListText);
        setBottom(startBottomArea);
        startCreateButton.setOnAction(event -> {
            Game.getInstance().addPlayer(startPlayerEntry.getText(), (String) startRadioGroup.getSelectedToggle().getUserData());

            startRadioGroup.getSelectedToggle().setSelected(false);
            startPlayerEntry.setText("");
        });

        startDoneButton.setOnAction(event -> {
            try {
                Game.getInstance().start();
            } catch (NotEnoughPlayersException e) {
                startPlayerListText.appendText("\nERROR NOT ENOUGH PLAYERS\n\n");
            }
        });

        Game.getInstance().addListener(new GameListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onPlayerAdded(Player player) {
                startPlayerListText.appendText(player.getName() + "\n");

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

            }

            @Override
            public void onMessage(String message) {

            }

        });
    }
}
