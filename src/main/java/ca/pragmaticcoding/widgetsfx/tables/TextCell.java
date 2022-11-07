package ca.pragmaticcoding.widgetsfx.tables;

import javafx.scene.control.TableCell;
import javafx.scene.text.Text;

public class TextCell<TableModel> extends TableCell<TableModel, String> {

    Text text = new Text();

    public TextCell() {
        initialize();
    }

    public TextCell(double wrappingWidth) {
        initialize();
        text.setWrappingWidth(wrappingWidth);
    }

    private void initialize() {
        text.getStyleClass().add("data-text-cell");
        text.textProperty().bind(itemProperty());
        setGraphic(text);
    }
}
