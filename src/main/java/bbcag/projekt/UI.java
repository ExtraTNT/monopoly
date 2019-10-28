package bbcag.projekt;


import bbcag.projekt.engine.Game;
import bbcag.projekt.engine.GameListener;
import bbcag.projekt.player.Player;
import bbcag.projekt.ui.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UI extends Application {
    /**
     * start
     * the "main" because javafx (see javafx-doc)
     * @param primaryStage the primary stage -> whats happen on the screen
     */
    @Override
    public void start(Stage primaryStage){

        DealUI dealUI = new DealUI();

        Scene mainScene = new Scene(new MainUI(), Color.WHITE);
        Scene startScene = new Scene(new StartUI(), Color.WHITE);
        Scene dealScene = new Scene(dealUI, Color.WHITE);
        Scene hotelScene = new Scene(new HotelUI(), Color.WHITE);
        Scene winScene = new Scene(new WinnerUI(), Color.WHITE);

        primaryStage.setScene(startScene);

        /**GameListener
         * Interface for easy control, used on all GUI elements and in the engine
         */
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
            }

            @Override
            public void onDicesRolled(int dice1, int dice2) {

            }

            @Override
            public void onStartDealing(Player currentPlayer) {

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