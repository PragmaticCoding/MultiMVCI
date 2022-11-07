package ca.pragmaticcoding.multimvci.function3;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class Function3Controller {

    Builder<Region> viewBuilder;
    Function3Model model = new Function3Model();

    public Function3Controller() {
        Function3Interactor interactor = new Function3Interactor(model);
        viewBuilder = new Function3ViewBuilder(model, () -> interactor.convertToUpperCase());
    }

    public Region getView() {
        return viewBuilder.build();
    }

}
