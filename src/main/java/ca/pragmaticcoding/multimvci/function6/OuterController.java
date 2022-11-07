package ca.pragmaticcoding.multimvci.function6;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class OuterController {

    private final OuterInteractor interactor;
    Builder<Region> viewBuilder;
    OuterModel model = new OuterModel();
    InnerController innerController;

    public OuterController() {
        interactor = new OuterInteractor(model);
        innerController = new InnerController(model.property3Property(), this::handleInnerLookup);
        viewBuilder = new OuterViewBuilder(model, innerController.getView());
    }

    private void handleInnerLookup(Runnable innerRunnable) {
        interactor.preProcessLookup();
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                interactor.performLookup();
                return null;
            }
        };
        task.setOnSucceeded(evt -> {
            interactor.updateModelFromLookup();
            innerRunnable.run();
        });
        Thread taskThread = new Thread(task);
        taskThread.start();
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
