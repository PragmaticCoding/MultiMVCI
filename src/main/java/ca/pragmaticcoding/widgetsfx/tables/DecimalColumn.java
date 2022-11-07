package ca.pragmaticcoding.widgetsfx.tables;

import javafx.beans.value.ObservableValue;
import javafx.util.Callback;

public class DecimalColumn<TableModel> extends ConfigurableColumn<DecimalColumn<TableModel>, TableModel, Double> {

    private String formatString = "#.00";

    public DecimalColumn(String columnHeading) {
        super(columnHeading);
        setCellFactory(column -> new DecimalCell<>(formatString));
    }

    @Override
    protected DecimalColumn<TableModel> getThis() {
        return this;
    }

    public DecimalColumn(String columnHeading,
                         Callback<CellDataFeatures<TableModel, Double>, ObservableValue<Double>> valueCallback) {
        super(columnHeading);
        setCellFactory(column -> new DecimalCell<>(formatString));
        setCellValueFactory(valueCallback);
    }

    public DecimalColumn<TableModel> withFormat(String formatString) {
        this.formatString = formatString;
        setCellFactory(column -> new DecimalCell<>(formatString));
        return this;
    }

}
