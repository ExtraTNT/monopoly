package bbcag.projekt.ui;

import bbcag.projekt.engine.Game;
import bbcag.projekt.engine.GameListener;
import bbcag.projekt.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WinnerUI extends BorderPane {
    public WinnerUI() {
        VBox winnerBox = new VBox();
        this.setMinSize(1200, 200);

        winnerBox.setAlignment(Pos.BASELINE_CENTER);

        Label winLabel = new Label();
        winLabel.setFont(new Font(50));
        Button winButton = new Button("Exit");
        winButton.setPrefSize(200, 100);

        winnerBox.getChildren().addAll(winLabel, winButton);
        this.setCenter(winnerBox);

        //Clicking this button makes you exit
        winButton.setOnAction(event -> System.exit(0));

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
                winLabel.setText("Game Over! " + winer.getName() + " wins the game!");
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

            @Override
            public void onCardShow() {

            }
        });
    }
}
