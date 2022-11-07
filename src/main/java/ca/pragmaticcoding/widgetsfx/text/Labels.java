package ca.pragmaticcoding.widgetsfx.text;

import javafx.beans.value.ObservableStringValue;
import javafx.scene.control.Label;

public class Labels {

    public static Label styled(String textValue, String styleClass) {
        Label results = new Label(textValue);
        results.getStyleClass().add(styleClass);
        return results;
    }

    public static Label styled(ObservableStringValue textValue, String styleClass) {
        Label results = styled("", styleClass);
        results.textProperty().bind(textValue);
        return results;
    }

    public static Label h1(ObservableStringValue textValue) {
        return styled(textValue, "label-h1");
    }

    public static Label h1(String textValue) {
        return styled(textValue, "label-h1");
    }

    public static Label h2(String textValue) {
        return styled(textValue, "label-h2");
    }

    public static Label h2(ObservableStringValue textValue) {
        return styled(textValue, "label-h2");
    }

    public static Label h3(String textValue) {
        return styled(textValue, "label-h3");
    }

    public static Label h3(ObservableStringValue textValue) {
        return styled(textValue, "label-h3");
    }

    public static Label h4(String textValue) {
        return styled(textValue, "label-h4");
    }

    public static Label h4(ObservableStringValue textValue) {
        return styled(textValue, "label-h4");
    }

    public static Label prompt(String textValue) {
        return styled(textValue, "label-prompt");
    }

    public static Label prompt(ObservableStringValue textValue) {
        return styled(textValue, "label-prompt");
    }

    public static Label data(String textValue) {
        return styled(textValue, "label-data");
    }

    public static Label data(ObservableStringValue textValue) {
        return styled(textValue, "label-data");
    }


}
