package ca.pragmaticcoding.widgetsfx.text;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

/**
 * Filter to support Integer based TextField input
 */

public class IntegerFilter implements UnaryOperator<TextFormatter.Change> {

    @Override
    public TextFormatter.Change apply(TextFormatter.Change change) {
        String newText = change.getControlNewText();
        if (newText.matches("-?([1-9][0-9]*)?") || newText.equals("0")) {
            return change;
        } else if ("-".equals(change.getText())) {
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
        return null;
    }
}
