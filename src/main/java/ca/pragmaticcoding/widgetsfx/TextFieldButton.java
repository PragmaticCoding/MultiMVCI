package ca.pragmaticcoding.widgetsfx;

import ca.pragmaticcoding.widgetsfx.text.Labels;
import ca.pragmaticcoding.widgetsfx.text.Texts;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.function.Consumer;

/**
 * Encapsulated label, TextField and action button.  The action button is automatically
 * disabled once clicked, and re-enabled after the action consumer has completed.
 */

public class TextFieldButton extends HBox {

    private final String label;
    private final String buttonText;
    private final StringProperty boundValue;
    private final Consumer<Runnable> buttonAction;
    private Runnable preRunAction;
    private Runnable postRunAction;

    /**
     * Standard constructor
     *
     * @param label        String contents of the label Text
     * @param buttonText   String label for the action button
     * @param boundValue   String property bi-directionally bound to the input TextField
     * @param buttonAction Consumer of Runnable to perform the button action
     */

    public TextFieldButton(String label, String buttonText, StringProperty boundValue, Consumer<Runnable> buttonAction) {
        this.label = label;
        this.boundValue = boundValue;
        this.buttonAction = buttonAction;
        this.buttonText = buttonText;
        initialize();
    }

    private void initialize() {
        setSpacing(6d);
        setAlignment(Pos.CENTER_LEFT);
        Button button = new Button(buttonText);
        TextField textField = Texts.textField(boundValue);
        button.setOnAction(evt -> {
            button.setDisable(true);
            if (preRunAction != null) {
                preRunAction.run();
            }
            buttonAction.accept(() -> {
                if (postRunAction != null) {
                    postRunAction.run();
                }
                button.setDisable(false);
            });
        });
        button.defaultButtonProperty()
                .bind(Bindings.createBooleanBinding(() -> (textField.isFocused() && !textField.getText().isEmpty()),
                        textField.focusedProperty(),
                        textField.textProperty()));
        getChildren().addAll(Labels.prompt(label), textField, button);
    }

    /**
     * Decorator to add an action to be run on the FXAT BEFORE the
     * action Consumer is invoked.
     *
     * @param preRunAction Runnable to be performed before action consumer is invoked
     * @return
     */

    public TextFieldButton withPreRunAction(Runnable preRunAction) {
        this.preRunAction = preRunAction;
        return this;
    }

    /**
     * Decorator to add an action to be run on the FXAT AFTER the action
     * consumer has been invoked
     *
     * @param postRunAction
     * @return
     */

    public TextFieldButton withPostRunAction(Runnable postRunAction) {
        this.postRunAction = postRunAction;
        return this;
    }
}
