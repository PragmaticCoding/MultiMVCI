package ca.pragmaticcoding.multimvci.function3;

public class Function3Interactor {

    private final Function3Model model;

    public Function3Interactor(Function3Model model) {
        this.model = model;
    }

    void convertToUpperCase() {
        model.setUcPlanet(model.getPlanet().toUpperCase());
    }
}
