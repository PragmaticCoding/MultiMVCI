package ca.pragmaticcoding.multimvci.mainmvci;

import ca.pragmaticcoding.multimvci.function1.Function1Controller;
import ca.pragmaticcoding.multimvci.function2.Function2Controller;
import ca.pragmaticcoding.multimvci.function3.Function3Controller;
import ca.pragmaticcoding.multimvci.function4.Function4Controller;
import ca.pragmaticcoding.multimvci.function5.Function5Controller;
import ca.pragmaticcoding.multimvci.function6.OuterController;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class MainMvciController {
    private final Builder<Region> viewBuilder;

    public MainMvciController() {
        MainMvciModel model = new MainMvciModel();
        viewBuilder = new MainMvciViewBuilder(model,
                new Function1Controller().getView(),
                new Function2Controller().getView(),
                new Function3Controller().getView(),
                new Function4Controller().getView(),
                new Function5Controller().getView(),
                new OuterController().getView()
        );
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
