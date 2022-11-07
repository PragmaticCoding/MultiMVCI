package ca.pragmaticcoding.widgetsfx.tables;

import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.text.Text;

public class IntegerCell<TableModel> extends TableCell<TableModel, Integer> {

    Text text = new Text();

    public IntegerCell() {
        text.getStyleClass().add("data-text");
        text.textProperty().bind(Bindings.createStringBinding(() -> (itemProperty().get() != null) ? itemProperty().get().toString() : "",
                itemProperty()));
        setGraphic(text);
        setAlignment(Pos.CENTER_RIGHT);
    }
}