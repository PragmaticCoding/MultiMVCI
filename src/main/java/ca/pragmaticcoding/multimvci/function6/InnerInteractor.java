package ca.pragmaticcoding.multimvci.function6;

public class InnerInteractor {


    private final InnerModel model;

    public InnerInteractor(InnerModel model) {
        this.model = model;
        model.variable2Property().set("Not Started");
    }

    public void preLookupProcessing() {
        model.setVariable1("Prefix-" + model.getVariable1());
        model.variable2Property().set("Started");
    }

    public void postLookupProcessing() {
        model.setVariable2("All done");
    }

}
