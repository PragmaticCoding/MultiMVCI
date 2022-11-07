package ca.pragmaticcoding.widgetsfx.mvci;

public abstract class ScreenInteractor<ViewModelClass> {

    protected final ViewModelClass viewModel;

    protected ScreenInteractor(ViewModelClass viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Method designed to be run in a background thread called by the
     * ScreenController load() method from inside a Task call() method.
     * Ideally, this method should contain all of the initialization of
     * Domain objects from external API's and the persistence layer
     */

    public abstract void fetchData();

    /**
     * Method designed to be run on the FXAT to load data received via
     * the fetchData() method into the ViewModel.  This method is called
     * from the load() method of the ScreenController via the setOnSucceeded()
     * method of a Task.
     */

    public abstract void updateModel();

}
