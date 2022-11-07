package ca.pragmaticcoding.widgetsfx.tables;

import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

public class DecimalCell<TableModel> extends TableCell<TableModel, Double> {

    Text text = new Text();
    DecimalFormat df = new DecimalFormat("#.00");

    public DecimalCell() {
        super();
        initialize();
    }

    public DecimalCell(String formatPattern) {
        super();
        df = new DecimalFormat(formatPattern);
        initialize();
    }

    private void initialize() {
        text.getStyleClass().add("data-text");
        text.textProperty().bind(Bindings.createStringBinding(() -> (itemProperty().get() != null) ? df.format(itemProperty().get()) : "",
                itemProperty()));
        setGraphic(text);
        setAlignment(Pos.CENTER_RIGHT);
    }
}