package ca.pragmaticcoding.multimvci.function6;

public class DomainObject {

    private final String value1;
    private final String value2;
    private final String value3;
    private final String value4;

    public DomainObject(String value1, String value2, String value3, String value4) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public String getValue3() {
        return value3;
    }

    public String getValue4() {
        return value4;
    }
}
