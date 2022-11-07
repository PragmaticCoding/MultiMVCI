package ca.pragmaticcoding.widgetsfx.text;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

/**
 * Filter to support fixed decimal place input via a TextField.
 * TextField will operate as two linked data entry fields on either
 * side of the decimal point.
 */

public class FixedDecimalFilter implements UnaryOperator<TextFormatter.Change> {

    private final int decimalPlaces;

    public FixedDecimalFilter(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public TextFormatter.Change apply(TextFormatter.Change change) {
        int decimalPos = change.getControlText().indexOf(".");
        int caretPos = change.getControlCaretPosition();
        switch (change.getText()) {
            case "." -> {
                change.setText("");
                change.setRange(0, 0);
                if (caretPos <= decimalPos) {
                    change.setCaretPosition(decimalPos + 1);
                    change.setAnchor(change.getControlText().length());
                } else {
                    change.setCaretPosition(decimalPos);
                    change.setAnchor(0);
                }
                return change;
            }
            case "-" -> {
                if (change.getControlText().startsWith("-")) {
                    change.setText("");
                    change.setRange(0, 1);
                    change.setCaretPosition(change.getCaretPosition() - 2);
                    change.setAnchor(change.getAnchor() - 2);
                } else {
                    change.setRange(0, 0);
                }
                return change;
            }
            default -> {
            }
        }
        if ((change.getSelection().getStart() == 0) && (change.getSelection().getEnd() == change.getControlText().length())) {
            change.selectRange(0, decimalPos);
            return change;
        }
        if ((change.getAnchor() <= decimalPos) && (change.getCaretPosition() > decimalPos)) {
            change.selectRange(0, decimalPos);
            return change;
        }
        if ((change.getAnchor() > decimalPos) && (change.getCaretPosition() <= decimalPos)) {
            change.selectRange(decimalPos + 1, change.getControlText().length());
            return change;
        }
        if (change.isContentChange()) {
            if (caretPos > decimalPos) {
                String newText = change.getControlNewText();
                int decimalSize = newText.substring(decimalPos + 1).length();
                if (decimalSize < decimalPlaces) {
                    change.setText(change.getText() + "0");
                }
                if (decimalSize > decimalPlaces) {
                    change.setRange(decimalPos + 1, decimalPos + 1 + decimalPlaces);
                    if (caretPos == newText.length()) {
                        change.setText(newText.substring(decimalPos + 2, decimalPos + 2 + decimalPlaces));
                    } else {
                        change.setText(newText.substring(decimalPos + 1, decimalPos + 1 + decimalPlaces));
                    }
                }
            }
        }
        if (change.getControlNewText().matches("-?([0-9]*)?(\\.[0-9]*)?")) {
            return change;
        }
        return null;
    }
}
