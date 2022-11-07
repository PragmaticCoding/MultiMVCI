package ca.pragmaticcoding.multimvci.function6;

import ca.pragmaticcoding.widgetsfx.TextFieldButton;
import ca.pragmaticcoding.widgetsfx.text.DataText;
import ca.pragmaticcoding.widgetsfx.text.Labels;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

import java.util.function.Consumer;

public class InnerViewBuilder implements Builder<Region> {

    private final InnerModel model;
    private final Consumer<Runnable> lookupAction;

    public InnerViewBuilder(InnerModel model, Consumer<Runnable> lookupAction) {
        this.model = model;
        this.lookupAction = lookupAction;
    }

    @Override
    public Region build() {
        VBox results = new VBox(10,
                Labels.h4("Inner View"),
                new TextFieldButton("Inner Property 1:", "Find", model.variable1Property(), lookupAction),
                new HBox(6,
                        Labels.prompt("Processing:"),
                        new DataText(model.variable2Property())
                )
        );
        results.getStyleClass().add("standard-border");
        results.setPadding(new Insets(10));
        return results;
    }
}
