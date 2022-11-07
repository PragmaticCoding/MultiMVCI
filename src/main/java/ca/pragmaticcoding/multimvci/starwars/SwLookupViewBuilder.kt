package ca.pragmaticcoding.multimvci.starwars

import ca.pragmaticcoding.widgetsfx.text.Labels
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.Region
import javafx.util.Builder
import java.util.function.Consumer

class SwLookupViewBuilder(private val viewModel: SwModel, private val searchHandler: Consumer<Runnable>) : Builder<Region> {

   override fun build(): Region = HBox(6.0).apply {
      children += Labels.prompt("Name:")
      children += TextField().apply {
         textProperty().bindBidirectional(viewModel.name)
      }
      children += Button("Search").apply {
         onAction = EventHandler {
            isDisable = true
            searchHandler.accept { isDisable = false }
         }
      }
   }
}