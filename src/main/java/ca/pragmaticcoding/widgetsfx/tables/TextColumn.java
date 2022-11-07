package ca.pragmaticcoding.widgetsfx.tables;

import javafx.beans.value.ObservableValue;
import javafx.util.Callback;

public class TextColumn<TableModel> extends ConfigurableColumn<TextColumn<TableModel>, TableModel, String> {

    public TextColumn(String columnHeading) {
        super(columnHeading);
        setCellFactory(column -> new TextCell<>());
    }

    @Override
    protected TextColumn<TableModel> getThis() {
        return this;
    }

    public TextColumn(String columnHeading, Callback<CellDataFeatures<TableModel, String>, ObservableValue<String>> valueCallback) {
        super(columnHeading);
        setCellFactory(column -> new TextCell<>());
        setCellValueFactory(valueCallback);
    }

    public TextColumn<TableModel> withWrappingWidth(double wrappingWidth) {
        setCellFactory(column -> new TextCell<>(wrappingWidth));
        return this;
    }
}
