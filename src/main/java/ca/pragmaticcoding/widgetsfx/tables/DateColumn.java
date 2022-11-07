package ca.pragmaticcoding.widgetsfx.tables;

import javafx.beans.value.ObservableValue;
import javafx.util.Callback;

import java.time.LocalDate;

public class DateColumn<TableModel> extends ConfigurableColumn<DateColumn<TableModel>, TableModel, LocalDate> {

    public DateColumn(String columnHeading) {
        super(columnHeading);
        initialize();
    }

    public DateColumn(String columnHeading, Callback<CellDataFeatures<TableModel, LocalDate>, ObservableValue<LocalDate>> valueCallback) {
        super(columnHeading);
        setCellValueFactory(valueCallback);
        initialize();
    }

    private void initialize() {
        setMinWidth(80);
        setMaxWidth(80);
        setCellFactory(column -> new DateCell<>());
    }

    @Override
    protected DateColumn<TableModel> getThis() {
        return this;
    }
}
