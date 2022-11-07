package ca.pragmaticcoding.widgetsfx.text;

import javafx.animation.Transition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableStringValue;
import javafx.css.PseudoClass;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * A specialized form of Text, designed to display data values
 * and as an alternative to using disabled TextFields.
 * This element uses the CSS selector "data-text", and has a
 * pseudo-class ":error" to handle display when the data is flagged
 * as being in an error state.
 * One of the elements missing from Text, but present in Label, is
 * the ability to copy the contents to the clipboard.  This control has
 * this functionality added, where <CTRL><RightClick> will copy the
 * entire contents of the Text to the clipboard.  Additionally, a small
 * animation will run to cue the user that the copy has happened.
 */


public class DataText extends Text {

    private static final PseudoClass ERROR_CLASS = PseudoClass.getPseudoClass("error");
    private final BooleanProperty errorFlag = new SimpleBooleanProperty(false);

    /**
     * Creates a DataText bound to an ObservableStringValue
     *
     * @param boundValue ObsevableValue to bind to the Text property
     */

    public DataText(ObservableStringValue boundValue) {
        super();
        initialize();
        textProperty().bind(boundValue);
    }

    /**
     * Creates a DataText with static/manually set Text value
     *
     * @param text String to display in the Text
     */

    public DataText(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
        errorFlag.addListener(e -> pseudoClassStateChanged(ERROR_CLASS, errorFlag.get()));
        getStyleClass().add("data-text");
        setOnMouseClicked(evt -> {
            if (evt.getButton().equals(MouseButton.SECONDARY) && evt.isControlDown()) {
                final Clipboard clipboard = Clipboard.getSystemClipboard();
                final ClipboardContent content = new ClipboardContent();
                content.putString(getText());
                clipboard.setContent(content);
                animateClipboardCapture();
            }
        });
    }

    private void animateClipboardCapture() {
        Transition transition = new Transition() {
            {
                setCycleDuration(Duration.millis(150));
                setAutoReverse(true);
                setCycleCount(2);
            }

            @Override
            protected void interpolate(double frac) {
                setScaleX(1 - frac / 4);
                setScaleY(1 - frac / 5);
            }
        };
        transition.play();
    }

    /**
     * Manually control the error status flag.
     *
     * @param errorFlag New value for errorFlag
     */

    public void setError(boolean errorFlag) {
        this.errorFlag.set(errorFlag);
    }

    /**
     * Determine the status of the error flag
     *
     * @return Current value of the error flag
     */

    public boolean isError() {
        return errorFlag.get();
    }

    /**
     * Getter for the error flag property
     *
     * @return Error flag BooleanProperty
     */

    public BooleanProperty errorProperty() {
        return errorFlag;
    }


    /**
     * Decorator to add binding of the error status to an external boolean property
     *
     * @param boundStatus External boolean property to bind to errorFlag
     * @return DataText now bound to external property
     */

    public DataText withBoundStatus(ObservableBooleanValue boundStatus) {
        errorFlag.bind(boundStatus);
        return this;
    }

}
