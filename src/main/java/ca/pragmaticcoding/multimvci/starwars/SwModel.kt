package ca.pragmaticcoding.multimvci.starwars

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

class SwModel {
   val name: StringProperty = SimpleStringProperty("Luke Skywalker")
   val gender: StringProperty = SimpleStringProperty("Unknown")
   val homePlanet: StringProperty = SimpleStringProperty("Earth")
}