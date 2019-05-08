package bbcag.projekt;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

public class UI extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {

            BorderPane mainArea = new BorderPane();
            Scene mainScene = new Scene(mainArea, Color.WHITE);


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
            buttonArea.getChildren().addAll(rollButton,dealButton,houseButton,turnButton);

            rollButton.setPrefSize(250,50);
            dealButton.setPrefSize(250,50);
            houseButton.setPrefSize(250,50);
            turnButton.setPrefSize(250,50);

            buttonArea.setPadding(new Insets(20));
            //Text and info stuff on the right

            VBox rightInfoArea = new VBox(3);

            TextField playerMoneyField = new TextField();
            TextField playerColourField = new TextField();

            ScrollPane playerPropertyScroll = new ScrollPane();



            TextField playerJailcardField = new TextField();

            ScrollPane playerAdditionalScroll = new ScrollPane();
            Label rollResult = new Label("_ and _");
            playerAdditionalScroll.setContent(rollResult);



            rightInfoArea.getChildren().addAll(playerMoneyField,playerColourField,playerPropertyScroll,playerJailcardField,playerAdditionalScroll);

            rightInfoArea.setPadding(new Insets(20));





            //Left area space info
            VBox leftInfoArea = new VBox(3);

            ScrollPane spacePropertyScroll = new ScrollPane();




            rollResult.setPrefHeight(50);
            rollResult.setPrefWidth(100);

            rollButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Random rand = new Random();
                    int dice1 = rand.nextInt(6);
                    dice1 += 1;
                    int dice2 = rand.nextInt(6);
                    dice2 += 1;
                    rollResult.setText(dice1 + " and " + dice2);
                }
            });




            mainArea.setCenter(gameBoard);
            mainArea.setBottom(buttonArea);
            mainArea.setRight(rightInfoArea);


            //Start screen
            BorderPane startScreen = new BorderPane();
            Scene startScene = new Scene(startScreen, Color.WHITE);
            VBox startCenterArea = new VBox(5);

            //Center area
            startCenterArea.setPadding(new Insets(20));
            Label startTitlePlayer = new Label("Player");
            TextField startPlayerEntry = new TextField();
            Label startTitleFigure = new Label("Figures");

            ToggleGroup startRadioGroup = new ToggleGroup();

            RadioButton startFigureRed = new RadioButton("Red");
            startFigureRed.setToggleGroup(startRadioGroup);

            RadioButton startFigureBlue = new RadioButton("Blue");
            startFigureBlue.setToggleGroup(startRadioGroup);

            RadioButton startFigureGreen = new RadioButton("Green");
            startFigureGreen.setToggleGroup(startRadioGroup);

            RadioButton startFigurePink = new RadioButton("Pink");
            startFigurePink.setToggleGroup(startRadioGroup);

            RadioButton startFigureYellow = new RadioButton("Yellow");
            startFigureYellow.setToggleGroup(startRadioGroup);

            RadioButton startFigurePurple = new RadioButton("Purple");
            startFigurePurple.setToggleGroup(startRadioGroup);

            startCenterArea.getChildren().addAll(
                    startTitlePlayer,startPlayerEntry,
                    startTitleFigure,startFigureRed,startFigureBlue,
                    startFigureGreen,startFigurePink,startFigureYellow,
                    startFigurePurple);

            //Bottom area
            HBox startBottomArea = new HBox(5);
            startBottomArea.setPadding(new Insets(20));
            Button startCreateButton = new Button("Create");
            Button startDoneButton = new Button("Done");
            startBottomArea.getChildren().addAll(startCreateButton,startDoneButton);

            //Right area
            ScrollPane startPlayerListScroll = new ScrollPane();

            startScreen.setCenter(startCenterArea);
            startScreen.setRight(startPlayerListScroll);
            startScreen.setBottom(startBottomArea);


            startDoneButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    primaryStage.setScene(mainScene);
                }
            });


            //Dealing scene
            BorderPane dealScreen = new BorderPane();
            HBox dealScreenHBox = new HBox();
            Scene dealScene = new Scene(dealScreen, Color.WHITE);

            //Left deal side
            TextField dealer1MoneyText = new TextField();
            ScrollPane dealer1PropertyScroll = new ScrollPane();
            Label dealer1FullMoneyLabel = new Label();
            TextField dealer1PropertyText = new TextField();
            dealer1PropertyScroll.setContent(dealer1FullMoneyLabel);

            VBox traderBox1 = new VBox(5);
            traderBox1.setPadding(new Insets(20));
            traderBox1.getChildren().addAll(dealer1MoneyText,dealer1PropertyScroll,dealer1FullMoneyLabel,dealer1PropertyText);

            //Right deal side
            TextField dealer2MoneyText = new TextField();
            ScrollPane dealer2PropertyScroll = new ScrollPane();
            Label dealer2FullMoneyLabel = new Label();
            TextField dealer2PropertyText = new TextField();
            dealer2PropertyScroll.setContent(dealer2FullMoneyLabel);

            VBox traderBox2 = new VBox(5);
            traderBox2.setPadding(new Insets(20));
            traderBox2.getChildren().addAll(dealer2MoneyText,dealer2PropertyScroll,dealer2FullMoneyLabel,dealer2PropertyText);


            //dealScreen bottom area
            Button dealDealButton = new Button("Deal");
            Button dealExitButton = new Button("Exit");

            dealButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    primaryStage.setScene(dealScene);
                }
            });

            dealExitButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    primaryStage.setScene(mainScene);
                }
            });

            HBox dealBottomArea = new HBox(5);
            dealBottomArea.setPadding(new Insets(10));


            dealBottomArea.getChildren().addAll(dealDealButton,dealExitButton);
            dealScreenHBox.getChildren().addAll(traderBox1,traderBox2);
            dealScreen.setCenter(dealScreenHBox);
            dealScreen.setBottom(dealBottomArea);

            primaryStage.setScene(startScene);
            primaryStage.show();
        }
    }


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