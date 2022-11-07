package ca.pragmaticcoding.multimvci.function4;

import ca.pragmaticcoding.multimvci.starwars.SwLookupController;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class Function4Controller {

    Builder<Region> viewBuilder;
    Function4Model model = new Function4Model();

    public Function4Controller() {
        Function4Interactor interactor = new Function4Interactor(model);
        SwLookupController planetFinderController = new SwLookupController(model.planetProperty());
        viewBuilder = new Function4ViewBuilder(model, planetFinderController.getView(), interactor::convertToUpperCase);
    }

    public Region getView() {
        return viewBuilder.build();
    }

}
