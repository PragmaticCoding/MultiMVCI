package ca.pragmaticcoding.multimvci.function6;

import ca.pragmaticcoding.widgetsfx.text.DataText;
import ca.pragmaticcoding.widgetsfx.text.Labels;
import javafx.beans.value.ObservableStringValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class OuterViewBuilder implements Builder<Region> {

    private final OuterModel model;
    private final Region innerView;

    public OuterViewBuilder(OuterModel model, Region encapsulatedView) {
        this.model = model;
        this.innerView = encapsulatedView;
    }


    @Override
    public Region build() {
        VBox results = new VBox(20,
                Labels.h3("Outer/Inner MVCI"),
                innerView,
                createPromptData("Value 1:", model.property1Property()),
                createPromptData("Value 2:", model.property2Property()),
                createTextArea()
        );
        results.setPadding(new Insets(40));
        return results;
    }

    private Region createPromptData(String prompt, ObservableStringValue data) {
        HBox results = new HBox(6, Labels.prompt(prompt), new DataText(data));
        results.setAlignment(Pos.CENTER_LEFT);
        return results;
    }

    private Node createTextArea() {
        TextArea textArea = new TextArea();
        textArea.textProperty().bind(model.property4Property());
        StackPane textBox = new StackPane(textArea);
        textBox.setPadding(new Insets(0, 0, 0, 60));
        VBox results = new VBox(6, Labels.prompt("Progress Messages:"), textBox);
        results.setPadding(new Insets(10));
        results.getStyleClass().add("standard-border");
        return results;
    }

}
