package ca.pragmaticcoding.multimvci.function5;

import ca.pragmaticcoding.widgetsfx.text.Labels;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class Function5ViewBuilder implements Builder<Region> {

    private final Function5Model model;
    private final Runnable convertAction;
    private final Runnable windowLauncher;

    public Function5ViewBuilder(Function5Model model, Runnable windowLauncher, Runnable convertAction) {
        this.model = model;
        this.convertAction = convertAction;
        this.windowLauncher = windowLauncher;
    }


    @Override
    public Region build() {
        VBox results = new VBox(20, Labels.h3("Planet Finder MVCI"), createWindowButton(), createUpperCaseBox());
        results.setPadding(new Insets(40));
        return results;
    }

    private Node createWindowButton() {
        Button results = new Button("Launch Window");
        results.setOnAction(evt -> windowLauncher.run());
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
