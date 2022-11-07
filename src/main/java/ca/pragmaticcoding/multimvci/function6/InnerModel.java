package ca.pragmaticcoding.multimvci.function6;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InnerModel {

    private final StringProperty variable1 = new SimpleStringProperty("");
    private final StringProperty variable2 = new SimpleStringProperty("");

    public String getVariable1() {
        return variable1.get();
    }

    public void setVariable1(String variable1) {
        this.variable1.set(variable1);
    }

    public StringProperty variable1Property() {
        return variable1;
    }

    public String getVariable2() {
        return variable2.get();
    }

    public void setVariable2(String variable2) {
        this.variable2.set(variable2);
    }

    public StringProperty variable2Property() {
        return variable2;
    }
}
