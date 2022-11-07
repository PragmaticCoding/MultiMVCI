package ca.pragmaticcoding.multimvci.function5;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Function5Model {

    private final StringProperty planet = new SimpleStringProperty("");
    private final StringProperty ucPlanet = new SimpleStringProperty("");

    public String getPlanet() {
        return planet.get();
    }

    public void setPlanet(String planet) {
        this.planet.set(planet);
    }

    public StringProperty planetProperty() {
        return planet;
    }

    public String getUcPlanet() {
        return ucPlanet.get();
    }

    public void setUcPlanet(String ucPlanet) {
        this.ucPlanet.set(ucPlanet);
    }

    public StringProperty ucPlanetProperty() {
        return ucPlanet;
    }
}
