package bbcag.projekt;


import bbcag.projekt.ui.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        DealUI dealUI = new DealUI();

        Scene mainScene = new Scene(new MainUI(), Color.WHITE);
        Scene startScene = new Scene(new StartUI(), Color.WHITE);
        Scene dealScene = new Scene(dealUI, Color.WHITE);
        Scene hotelScene = new Scene(new HotelUI(), Color.WHITE);
        Scene winScene = new Scene(new WinnerUI(), Color.WHITE);

        primaryStage.setScene(startScene);

        Game.getInstance().addListener(new GameListener() {
            @Override
            public void onStart() {
                primaryStage.setScene(mainScene);
            }

            @Override
            public void onPlayerAdded(Player player) {

            }

            @Override
            public void onCurrentPlayerChange(Player player) {
                // Empty
            }

            @Override
            public void onDicesRolled(int dice1, int dice2) {

            }

            @Override
            public void onStartDealing(Player currentPlayer) {
                dealUI.update();
                primaryStage.setScene(dealScene);
            }

            @Override
            public void onWin(Player winer) {
                primaryStage.setScene(winScene);
            }

            @Override
            public void onBuy(Player player) {

            }

            @Override
            public void onHotel() {
                primaryStage.setScene(hotelScene);
            }

            @Override
            public void onDone() {
                primaryStage.setScene(mainScene);
            }

            @Override
            public void onMessage(String message) {

            }
        });

        primaryStage.show();
    }
}