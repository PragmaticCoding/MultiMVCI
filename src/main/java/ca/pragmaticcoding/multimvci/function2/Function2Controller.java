package ca.pragmaticcoding.multimvci.function2;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class Function2Controller {

    Builder<Region> viewBuilder;

    public Function2Controller() {
        viewBuilder = new Function2ViewBuilder();
    }

    public Region getView() {
        return viewBuilder.build();
    }

}
