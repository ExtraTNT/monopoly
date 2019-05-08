package bbcag.projekt;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class UI extends Application {
    //UI <- Javafx

        @Override
        public void start(Stage primaryStage) throws Exception {
            GridPane mainArea = new GridPane();
            Scene scene = new Scene(mainArea, 500,400, Color.WHITE);

            BorderPane boardHolder = new BorderPane();

            ImageView gameBoard = new ImageView();

            boardHolder.setCenter(gameBoard);

            mainArea.addRow(0);
            mainArea.add(boardHolder, 0, 0);

            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }


