package ca.pragmaticcoding.widgetsfx.text;

import javafx.util.converter.DoubleStringConverter;

/**
 * Converter to support TextFields containing fixed place decimal
 * data input.
 */

public class FixedDecimalConverter extends DoubleStringConverter {

    private final int decimalPlaces;

    public FixedDecimalConverter(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public String toString(Double value) {
        return String.format("%." + decimalPlaces + "f", value);
    }

    @Override
    public Double fromString(String valueString) {
        if (valueString.isEmpty()) {
            return 0d;
        }
        return super.fromString(valueString);
    }

}
