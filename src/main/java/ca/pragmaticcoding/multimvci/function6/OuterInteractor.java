package ca.pragmaticcoding.multimvci.function6;

public class OuterInteractor {

    private final OuterModel model;
    private DomainObject domainObject;
    private String progressMessages = "";

    public OuterInteractor(OuterModel model) {
        this.model = model;
    }


    public void preProcessLookup() {
        model.setProperty4("Starting lookup\n");
        model.setProperty1("Pending...");
        model.setProperty2("Pending...");
        model.setProperty3(model.getProperty3().toUpperCase());
    }

    public void performLookup() {
        progressMessages = "About to perform lookup of " + model.getProperty3() + "\n";
        try {
            Thread.sleep(5000);
            domainObject = new DomainBroker().retrieveData(model.getProperty4());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        progressMessages += "Lookup completed\n";
    }

    public void updateModelFromLookup() {
        progressMessages += "Updating the Model\n";
        model.setProperty1(domainObject.getValue1());
        model.setProperty2(domainObject.getValue2() + ", " + domainObject.getValue3());
        model.setProperty4(model.getProperty4() + progressMessages);
    }
}
