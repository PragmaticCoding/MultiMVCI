package ca.pragmaticcoding.widgetsfx.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonWidgets {

    /**
     * Creates a Button with a specified label, and onAction event handler
     *
     * @param buttonText         Text to put on button
     * @param actionEventHandler EventHandler attached to onAction event
     * @return Button
     */

    public static Button actionButton(String buttonText, EventHandler<ActionEvent> actionEventHandler) {
        Button results = new Button(buttonText);
        results.setOnAction(actionEventHandler);
        return results;
    }

    /**
     * Creates a Button with a specified label, and onAction event handler
     * and StyleClass
     *
     * @param buttonText         Text to put on button
     * @param buttonStyle        StyleClass to apply to Button
     * @param actionEventHandler EventHandler attached to onAction event
     * @return Button
     */

    public static Button styledButton(String buttonText, String buttonStyle, EventHandler<ActionEvent> actionEventHandler) {
        Button results = actionButton(buttonText, actionEventHandler);
        results.getStyleClass().add(buttonStyle);
        return results;
    }
}
