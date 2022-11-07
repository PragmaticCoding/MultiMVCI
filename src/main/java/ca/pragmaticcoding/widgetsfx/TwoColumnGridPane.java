package ca.pragmaticcoding.widgetsfx;

import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class TwoColumnGridPane extends GridPane {
    public TwoColumnGridPane() {
        ColumnConstraints promptColumn = new ColumnConstraints();
        promptColumn.setHalignment(HPos.RIGHT);
        getColumnConstraints().add(promptColumn);
        setHgap(8);
        setPadding(new Insets(8));
//        getStyleClass().add("test-border");
    }

    public void addTextFieldRow(GridPane results, int row, StringProperty boundProperty) {
        TextField nameTF = new TextField();
        nameTF.textProperty().bindBidirectional(boundProperty);
        results.add(createPrompt("Name:"), 0, row);
        results.add(nameTF, 1, row);
    }

    private Label createPrompt(String promptText) {
        Label label = new Label(promptText);
        label.getStyleClass().add("label-prompt");
        return label;
    }

    public void addDisplayRow(GridPane results, int row, String s, StringProperty stringProperty) {
        results.add(createPrompt(s), 0, row);
        results.add(createBoundDataLabel(stringProperty), 1, row);
    }

    private Label createBoundDataLabel(StringProperty stringProperty) {
        Label genderLabel = new Label();
        genderLabel.getStyleClass().add("label-data");
        genderLabel.textProperty().bind(stringProperty);
        return genderLabel;
    }
}
