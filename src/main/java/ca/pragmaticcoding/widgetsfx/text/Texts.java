package ca.pragmaticcoding.widgetsfx.text;

import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * Static class with convenience methods to create styled Text based
 * nodes.  Elements depend on "default.css" for styling.
 */

public class Texts {

    /**
     * Method to create a bound, styled text.
     *
     * @param contents   Observable String Value to be bound to the Text property of the Text
     * @param styleClass The StyleClass selector to be added to the Text
     * @return Text node
     */

    public static Text styled(ObservableStringValue contents, String styleClass) {
        Text results = styled("", styleClass);
        results.textProperty().bind(contents);
        return results;
    }

    /**
     * Method to create a styled text.
     *
     * @param contents   Observable String Value to be bound to the Text property of the Text
     * @param styleClass The StyleClass selector to be added to the Text
     * @return Text node
     */

    public static Text styled(String contents, String styleClass) {
        Text results = new Text(contents);
        results.getStyleClass().add(styleClass);
        return results;
    }

    /**
     * Method to create a bound "Data" text.  See DataText for more details about the
     * functioning of that class.
     *
     * @param contents Observable String Value to bind to the Text property of the DataText
     * @return DataText node
     */

    public static Text data(ObservableStringValue contents) {
        return Texts.styled(contents, "data-text");
    }

    public static Text h1(ObservableStringValue textValue) {
        return styled(textValue, "text-h1");
    }

    public static Text h1(String textValue) {
        return styled(textValue, "text-h1");
    }

    public static Text h2(String textValue) {
        return styled(textValue, "text-h2");
    }

    public static Text h2(ObservableStringValue textValue) {
        return styled(textValue, "text-h2");
    }

    public static Text h3(String textValue) {
        return styled(textValue, "text-h3");
    }

    public static Text h3(ObservableStringValue textValue) {
        return styled(textValue, "text-h3");
    }

    public static Text h4(String textValue) {
        return styled(textValue, "text-h4");
    }

    public static Text h4(ObservableStringValue textValue) {
        return styled(textValue, "text-h4");
    }

    public static Text prompt(String textValue) {
        return styled(textValue, "text-prompt");
    }

    public static Text prompt(ObservableStringValue textValue) {
        return styled(textValue, "text-prompt");
    }


    /**
     * Method to create a "Label" Text.  Labels are intended to be prompts
     * on the screen and to stand out from data entry and data based fields.
     * As implemented, Labels are expected to contain static text defined in
     * the layout code.
     *
     * @param contents String to put in the label
     * @return Text node
     */

    public static Text label(String contents) {
        Text results = new Text(contents);
        results.getStyleClass().add("label-text");
        return results;
    }

    public static TextField textField(StringProperty contents) {
        TextField results = new TextField();
        results.textProperty().bindBidirectional(contents);
        results.getStyleClass().add("data-text");
        return results;
    }

    public static TextField decimalField(Property<Number> contents) {
        TextField results = new TextField();
        Bindings.bindBidirectional(results.textProperty(), contents, new NumberStringConverter());
        results.getStyleClass().add("data-text");
        return results;
    }

    public static TextField decimalField(Property<Number> contents, double maxWidth) {
        TextField results = decimalField(contents);
        results.setMaxWidth(maxWidth);
        return results;
    }

    public static TextField fixedDecimalField(Property<Double> boundProperty, int decimalPlaces, double maxWidth) {
        TextField results = new TextField();
        results.setMaxWidth(maxWidth);
        TextFormatter<Double> textFormatter =
                new TextFormatter<>(new FixedDecimalConverter(decimalPlaces), boundProperty.getValue(), new FixedDecimalFilter(decimalPlaces));
        results.setTextFormatter(textFormatter);
        boundProperty.bindBidirectional(textFormatter.valueProperty());
        return results;
    }

    public static TextField integerField(Property<Integer> boundProperty, double maxWidth) {
        TextField results = new TextField();
        results.setMaxWidth(maxWidth);
        TextFormatter<Integer> textFormatter = new TextFormatter<>(integerStringConverter(), boundProperty.getValue(), new IntegerFilter());
        results.setTextFormatter(textFormatter);
        boundProperty.bindBidirectional(textFormatter.valueProperty());
        return results;
    }

    private static StringConverter<Integer> integerStringConverter() {
        return new IntegerStringConverter() {
            @Override
            public Integer fromString(String s) {
                if (s.isEmpty()) {
                    return 0;
                }
                return super.fromString(s);
            }
        };
    }

}
