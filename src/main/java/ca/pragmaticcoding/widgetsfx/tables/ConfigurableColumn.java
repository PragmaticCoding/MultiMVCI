package ca.pragmaticcoding.widgetsfx.tables;


import javafx.scene.control.TableColumn;

public abstract class ConfigurableColumn<CHILD extends ConfigurableColumn<CHILD, S, T>, S, T> extends TableColumn<S, T> {

    public ConfigurableColumn(String columnHeading) {
        super(columnHeading);
    }

    protected abstract CHILD getThis();

    public CHILD withMinWidth(double width) {
        setMinWidth(width);
        return getThis();
    }

    public CHILD withMaxWidth(double width) {
        setMaxWidth(width);
        return getThis();
    }

    public CHILD withFixedWidth(double width) {
        setMinWidth(width);
        setMaxWidth(width);
        return getThis();
    }
}
