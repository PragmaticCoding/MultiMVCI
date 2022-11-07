package ca.pragmaticcoding.widgetsfx.tables;

import ca.pragmaticcoding.widgetsfx.text.Texts;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;

public class ProgressPlaceholder extends VBox {

    public ProgressPlaceholder(String message) {
        setSpacing(10);
        getChildren().addAll(new ProgressIndicator(-1), Texts.label(message));
        setFillWidth(true);
        setAlignment(Pos.CENTER);
    }
}
