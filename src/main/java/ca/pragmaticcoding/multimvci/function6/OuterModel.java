package ca.pragmaticcoding.multimvci.function6;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OuterModel {

    private final StringProperty property1 = new SimpleStringProperty("");
    private final StringProperty property2 = new SimpleStringProperty("");
    private final StringProperty property3 = new SimpleStringProperty("");
    private final StringProperty property4 = new SimpleStringProperty("");

    public String getProperty1() {
        return property1.get();
    }

    public void setProperty1(String property1) {
        this.property1.set(property1);
    }

    public StringProperty property1Property() {
        return property1;
    }

    public String getProperty2() {
        return property2.get();
    }

    public void setProperty2(String property2) {
        this.property2.set(property2);
    }

    public StringProperty property2Property() {
        return property2;
    }

    public String getProperty3() {
        return property3.get();
    }

    public void setProperty3(String property3) {
        this.property3.set(property3);
    }

    public StringProperty property3Property() {
        return property3;
    }

    public String getProperty4() {
        return property4.get();
    }

    public void setProperty4(String property4) {
        this.property4.set(property4);
    }

    public StringProperty property4Property() {
        return property4;
    }
}
