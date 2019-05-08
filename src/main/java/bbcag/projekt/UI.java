package bbcag.projekt;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

public class UI extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {

            BorderPane mainArea = new BorderPane();
            Scene scene = new Scene(mainArea, 500,400, Color.WHITE);



            ImageView gameBoard = new ImageView();


            Button rollButton = new Button("Roll");
            Label rollResult = new Label("");
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
            mainArea.setRight(rollButton);
            mainArea.setRight(rollResult);


            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }



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