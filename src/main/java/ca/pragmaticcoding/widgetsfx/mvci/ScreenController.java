package ca.pragmaticcoding.widgetsfx.mvci;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public abstract class ScreenController<ViewModelClass> {

    protected Builder<Region> viewBuilder;
    protected Region view;


    protected void load(Runnable postFetchGui) {
        Task<Void> fetchTask = new Task<>() {
            @Override
            protected Void call() {
                getInteractor().fetchData();
                return null;
            }
        };
        fetchTask.setOnSucceeded(evt -> {
            getInteractor().updateModel();
            postFetchGui.run();
        });
        Thread fetchThread = new Thread(fetchTask);
        fetchThread.start();
    }

    protected abstract ScreenInteractor<ViewModelClass> getInteractor();

    public Region getView() {
        if (view == null) {
            view = viewBuilder.build();
        }
        return view;
    }

}
