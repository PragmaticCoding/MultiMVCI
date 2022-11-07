package ca.pragmaticcoding.multimvci.function1;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class Function1ViewBuilder implements Builder<Region> {

    private final Region swContent;

    public Function1ViewBuilder(Region swContent) {
        this.swContent = swContent;
    }

    @Override
    public Region build() {
        return swContent;
    }
}
