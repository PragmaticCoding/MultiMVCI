package ca.pragmaticcoding.multimvci.function5;

import ca.pragmaticcoding.multimvci.starwars.SwLookupController;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Builder;

public class Function5Controller {

    Builder<Region> viewBuilder;
    Function5Model model = new Function5Model();
    SwLookupController planetFinderController;

    public Function5Controller() {
        Function5Interactor interactor = new Function5Interactor(model);
        planetFinderController = new SwLookupController(model.planetProperty());
        viewBuilder = new Function5ViewBuilder(model, this::launchWindow, interactor::convertToUpperCase);
    }

    private void launchWindow() {
        Stage stage = new Stage();
        stage.setScene(new Scene(planetFinderController.getView()));
        stage.show();
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
