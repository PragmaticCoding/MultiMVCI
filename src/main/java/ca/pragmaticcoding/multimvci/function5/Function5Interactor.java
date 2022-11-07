package ca.pragmaticcoding.multimvci.function5;

public class Function5Interactor {

    private final Function5Model model;

    public Function5Interactor(Function5Model model) {
        this.model = model;
    }

    void convertToUpperCase() {
        model.setUcPlanet(model.getPlanet().toUpperCase());
    }
}
