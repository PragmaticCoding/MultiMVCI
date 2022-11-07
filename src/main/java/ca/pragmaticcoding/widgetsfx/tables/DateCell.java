package ca.pragmaticcoding.widgetsfx.tables;

import ca.pragmaticcoding.widgetsfx.DateWidgets;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class DateCell<TableModel> extends TableCell<TableModel, LocalDate> {

    Text text = new Text();

    public DateCell() {
        super();
        initialize();
    }

    private void initialize() {
        text.getStyleClass().add("data-text-cell");
        text.textProperty().bind(Bindings.createStringBinding(() -> (itemProperty().get() != null) ?
                DateWidgets.formatDate(itemProperty().get()) : "", itemProperty()));
        setGraphic(text);
        setAlignment(Pos.CENTER_RIGHT);
    }

}
