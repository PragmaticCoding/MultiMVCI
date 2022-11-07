package ca.pragmaticcoding.widgetsfx.mvci;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public abstract class ViewBuilder<ViewModelClass> implements Builder<Region> {

    protected ViewModelClass viewModel;

    public ViewBuilder(ViewModelClass viewModel) {
        this.viewModel = viewModel;
    }
}
