package ca.pragmaticcoding.multimvci.function6;

import javafx.beans.property.StringProperty;
import javafx.scene.layout.Region;

import java.util.function.Consumer;

public class InnerController {
    private final Consumer<Runnable> outerLookupHandler;
    private final InnerInteractor interactor;
    InnerViewBuilder viewBuilder;

    public InnerController(StringProperty outerProperty, Consumer<Runnable> outerLookupHandler) {
        InnerModel model = new InnerModel();
        interactor = new InnerInteractor(model);
        viewBuilder = new InnerViewBuilder(model, this::performLookup);
        model.variable1Property().bindBidirectional(outerProperty);
        this.outerLookupHandler = outerLookupHandler;
    }

    private void performLookup(Runnable postActionGuiStuff) {
        interactor.preLookupProcessing();
        outerLookupHandler.accept(() -> {
            interactor.postLookupProcessing();
            postActionGuiStuff.run();
        });
    }

    public Region getView() {
        return viewBuilder.build();
    }

}
