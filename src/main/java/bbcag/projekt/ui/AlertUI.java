package bbcag.projekt.ui;

import bbcag.projekt.engine.Game;
import bbcag.projekt.engine.GameListener;
import bbcag.projekt.player.Player;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class AlertUI extends VBox {
    public AlertUI(){
        HBox buttonArea = new HBox();
        Label messageLabel = new Label();
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(event -> Done(true));
        noButton.setOnAction(event -> Done(false));

        buttonArea.getChildren().addAll(yesButton, noButton);
        getChildren().addAll(messageLabel, buttonArea);

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
            public void onDone() {}
            @Override
            public void onMessage(String message) {}
            @Override
            public void onCardShow() {}

            @Override
            public void onAlert(String message) {
                messageLabel.setText(message);
            }
        });
    }
    private void Done(boolean value){
        Game.getInstance().setAlertValue(value);
        Game.getInstance().onDone();
    }
}
