package ca.pragmaticcoding.widgetsfx.tables;

import javafx.beans.value.ObservableValue;
import javafx.util.Callback;

public class IntegerColumn<TableModel> extends ConfigurableColumn<IntegerColumn<TableModel>, TableModel, Integer> {

    public IntegerColumn(String columnHeading) {
        super(columnHeading);
        setCellFactory(column -> new IntegerCell<>());
    }

    @Override
    protected IntegerColumn<TableModel> getThis() {
        return this;
    }

    public IntegerColumn(String columnHeading, Callback<CellDataFeatures<TableModel, Integer>, ObservableValue<Integer>> valueCallback) {
        super(columnHeading);
        setCellFactory(column -> new IntegerCell<>());
        setCellValueFactory(valueCallback);
    }

    public IntegerColumn<TableModel> withPreferredWidth(double width) {
        setPrefWidth(width);
        return this;
    }

}
