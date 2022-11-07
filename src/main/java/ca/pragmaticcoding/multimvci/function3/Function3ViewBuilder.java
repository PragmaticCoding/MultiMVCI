package ca.pragmaticcoding.multimvci.function3;

import ca.pragmaticcoding.multimvci.starwars.SwPlanetFinder;
import ca.pragmaticcoding.widgetsfx.text.Labels;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class Function3ViewBuilder implements Builder<Region> {

    private final Function3Model model;
    private final Runnable convertAction;

    public Function3ViewBuilder(Function3Model model, Runnable convertAction) {
        this.model = model;
        this.convertAction = convertAction;
    }


    @Override
    public Region build() {
        SwPlanetFinder swPlanetFinder = new SwPlanetFinder();
        model.planetProperty().bind(swPlanetFinder.planetProperty());
        VBox results = new VBox(20, Labels.h3("Planet Finder Component"), swPlanetFinder, createUpperCaseBox());
        results.setPadding(new Insets(40));
        return results;
    }

    private Node createUpperCaseBox() {
        Label lcPlanet = Labels.data(model.planetProperty());
        Label ucPlanet = Labels.data(model.ucPlanetProperty());
        Button button = new Button("To Upper Case");
        button.setOnAction(evt -> convertAction.run());
        return new VBox(6,
                new HBox(10, lcPlanet, button),
                new HBox(6, Labels.prompt("In Upper Case: "),
                        ucPlanet));
    }
}
