package bbcag.projekt.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuyPropertyUI extends VBox {

    private Button buyPropertyScreenTrue;

    public BuyPropertyUI() {
        super(5);

        Label buyPropertyScreenTitle = new Label("Willst du dieses Feld Kaufen?");
        HBox buyPropertyScreenButtons = new HBox(5);

        buyPropertyScreenTrue = new Button("Kaufen");
        Button buyPropertyScreenFalse = new Button("Nicht Kaufen");
        buyPropertyScreenButtons.getChildren().addAll(buyPropertyScreenTrue, buyPropertyScreenFalse);

        getChildren().addAll(buyPropertyScreenTitle, buyPropertyScreenButtons);

        // buyPropertyScreenTrue.setOnAction(event -> {});
        // buyPropertyScreenFalse.setOnAction(event -> propertyPopUp.hide());
    }
}
