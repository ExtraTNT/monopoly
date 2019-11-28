package bbcag.projekt.ui;

import bbcag.projekt.config.Configuration;
import bbcag.projekt.engine.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class PreviewUI extends BorderPane {

    public PreviewUI(){
        HBox textFrame = new HBox();
        ImageView cardImageView = new ImageView("Card" + Configuration.getInstance().get("card.type") + ".png");
        cardImageView.setFitHeight(512);
        cardImageView.setFitWidth(256);
        StackPane centralStack = new StackPane();
        centralStack.getChildren().addAll(cardImageView, textFrame);

        Button PreviewUIDone = new Button("Done");
        PreviewUIDone.setPrefSize(180, 50);
        PreviewUIDone.setOnAction(event -> Game.getInstance().onDone());


        setAlignment(PreviewUIDone, Pos.CENTER);
        setCenter(centralStack);
        setBottom(PreviewUIDone);
    }
}
