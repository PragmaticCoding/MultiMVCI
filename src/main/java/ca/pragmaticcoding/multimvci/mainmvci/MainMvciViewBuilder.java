package ca.pragmaticcoding.multimvci.mainmvci;

import ca.pragmaticcoding.widgetsfx.text.Labels;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

import java.util.Objects;

public class MainMvciViewBuilder implements Builder<Region> {

    private final MainMvciModel model;
    private final Region function1Content;
    private final Region function2Content;
    private final Region function3Content;
    private final Region function4Content;
    private final Region function5Content;
    private final Region function6Content;

    public MainMvciViewBuilder(MainMvciModel model, Region function1Content, Region function2Content,
                               Region function3Content, Region function4Content,
                               Region function5Content, Region function6Content) {
        this.model = model;
        this.function1Content = function1Content;
        this.function2Content = function2Content;
        this.function3Content = function3Content;
        this.function4Content = function4Content;
        this.function5Content = function5Content;
        this.function6Content = function6Content;
    }

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        results.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/css/default.css")).toExternalForm());
        results.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/css/widgetsfx.css")).toExternalForm());
        results.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/css/starwars.css")).toExternalForm());

        results.setLeft(createButtons());
        results.setCenter(createCentre());
        return results;
    }

    private Node createButtons() {
        ToggleButton function1 = new ToggleButton("Autonomous");
        ToggleButton function2 = new ToggleButton("Encapsulated");
        ToggleButton function3 = new ToggleButton("Data Sharing 1");
        ToggleButton function4 = new ToggleButton("Data Sharing 2");
        ToggleButton function5 = new ToggleButton("Second Scene");
        ToggleButton function6 = new ToggleButton("Master Interactor");
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(function1, function2, function3, function4, function5, function6);
        model.function1SelectedProperty().bind(function1.selectedProperty());
        model.function2SelectedProperty().bind(function2.selectedProperty());
        model.function3SelectedProperty().bind(function3.selectedProperty());
        model.function4SelectedProperty().bind(function4.selectedProperty());
        model.function5SelectedProperty().bind(function5.selectedProperty());
        model.function6SelectedProperty().bind(function6.selectedProperty());
        VBox results = new VBox(20, Labels.h4("Functions"), function1, function2, function3,
                function4, function5, function6);
        results.setPadding(new Insets(14));
        return results;
    }

    private Region createCentre() {
        function1Content.visibleProperty().bind(model.function1SelectedProperty());
        function2Content.visibleProperty().bind(model.function2SelectedProperty());
        function3Content.visibleProperty().bind(model.function3SelectedProperty());
        function4Content.visibleProperty().bind(model.function4SelectedProperty());
        function5Content.visibleProperty().bind(model.function5SelectedProperty());
        function6Content.visibleProperty().bind(model.function6SelectedProperty());
        return new StackPane(function1Content, function2Content, function3Content,
                function4Content, function5Content, function6Content);
    }
}
