package bbcag.projekt;


import bbcag.projekt.ui.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene mainScene = new Scene(new MainUI(), Color.WHITE);
        Scene startScene = new Scene(new StartUI(), Color.WHITE);
        Scene dealScene = new Scene(new DealUI(), Color.WHITE);
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
                // TODO Show dealing window
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
        });


        primaryStage.show();

        /*
        //Buy property screen
        Stage propertyPopUp = new Stage();
        Scene propertyScene = new Scene(new BuyPropertyUI(), Color.WHITE);

        propertyPopUp.setScene(propertyScene);
        propertyPopUp.show();
         */


    }

    /*
    // MODEL CONTROLLER VIEW AREA
    class Model {
        private SimpleIntegerProperty currentValue = new SimpleIntegerProperty(0);

        public int getCurrentValue() {
            return currentValue.get();
        }

        public SimpleIntegerProperty currentValueProperty() {
            return currentValue;
        }

        public void setCurrentValue(int currentValue) {
            this.currentValue.set(currentValue);
        }

    }

    class Controller {

        private Model model;

        public Controller(Model model) {
            this.model = model;
        }

        public void handleButtonClick() {
            model.setCurrentValue(model.getCurrentValue() + 1);
        }
    }

    class View {
        private final Controller controller;
        private final Model model;
        private Label numberLabel;
        private Button incrementButton;

        public View(Controller controller, Model model) {
            this.controller = controller;
            this.model = model;

            incrementButton = new Button("Increment");
            numberLabel = new Label("0");

            listenToModelChange();
            registerButtonActionHandler();
        }

        private void registerButtonActionHandler() {
            incrementButton.setOnAction(actionEvent -> controller.handleButtonClick());
        }

        private void listenToModelChange() {
            model.currentValueProperty().addListener((observable, oldNumber, newNumber) ->
                    numberLabel.setText((newNumber.toString())));
        }
    }
    */
}