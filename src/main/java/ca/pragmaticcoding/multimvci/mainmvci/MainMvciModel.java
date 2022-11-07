package ca.pragmaticcoding.multimvci.mainmvci;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class MainMvciModel {
    private final BooleanProperty function1Selected = new SimpleBooleanProperty(false);
    private final BooleanProperty function2Selected = new SimpleBooleanProperty(false);
    private final BooleanProperty function3Selected = new SimpleBooleanProperty(false);
    private final BooleanProperty function4Selected = new SimpleBooleanProperty(false);
    private final BooleanProperty function5Selected = new SimpleBooleanProperty(false);
    private final BooleanProperty function6Selected = new SimpleBooleanProperty(false);

    public BooleanProperty function1SelectedProperty() {
        return function1Selected;
    }

    public BooleanProperty function2SelectedProperty() {
        return function2Selected;
    }

    public BooleanProperty function3SelectedProperty() {
        return function3Selected;
    }

    public BooleanProperty function4SelectedProperty() {
        return function4Selected;
    }

    public BooleanProperty function5SelectedProperty() {
        return function5Selected;
    }

    public BooleanProperty function6SelectedProperty() {
        return function6Selected;
    }
}
