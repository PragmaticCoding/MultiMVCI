package ca.pragmaticcoding.multimvci.starwars

import javafx.beans.property.ReadOnlyStringProperty

class SwPlanetFinder : SwLookupBox() {

   fun planetProperty(): ReadOnlyStringProperty = viewModel.homePlanet
}