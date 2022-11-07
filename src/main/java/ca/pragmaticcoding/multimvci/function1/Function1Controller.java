package ca.pragmaticcoding.multimvci.function1;

import ca.pragmaticcoding.multimvci.starwars.SwController;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class Function1Controller {

    Builder<Region> viewBuilder;

    public Function1Controller() {
        viewBuilder = new Function1ViewBuilder(new SwController().getView());
    }

    public Region getView() {
        return viewBuilder.build();
    }

}
