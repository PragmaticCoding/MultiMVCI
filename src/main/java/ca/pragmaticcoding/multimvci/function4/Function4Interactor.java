package ca.pragmaticcoding.multimvci.function4;

public class Function4Interactor {

    private final Function4Model model;

    public Function4Interactor(Function4Model model) {
        this.model = model;
    }

    void convertToUpperCase() {
        model.setUcPlanet(model.getPlanet().toUpperCase());
    }
}
