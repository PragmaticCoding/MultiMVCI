package ca.pragmaticcoding.multimvci.function2;

import ca.pragmaticcoding.multimvci.starwars.SwLookupBox;
import ca.pragmaticcoding.widgetsfx.text.Labels;
import javafx.geometry.Insets;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class Function2ViewBuilder implements Builder<Region> {
    @Override
    public Region build() {
        VBox results = new VBox(6, Labels.h3("Star Wars Lookup"), new SwLookupBox());
        results.setPadding(new Insets(40));
        return results;
    }
}
