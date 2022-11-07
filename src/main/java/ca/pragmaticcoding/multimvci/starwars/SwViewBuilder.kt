package ca.pragmaticcoding.multimvci.starwars

import ca.pragmaticcoding.widgetsfx.TwoColumnGridPane
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Region
import javafx.util.Builder
import java.util.function.Consumer

class SwViewBuilder(private val viewModel: SwModel, private val searchHandler: Consumer<Runnable>) : Builder<Region> {
   override fun build(): Region = BorderPane().apply {
//      stylesheets.add(Objects.requireNonNull(this.javaClass.getResource("default.css")).toExternalForm())
      styleClass.add("sw-pane")
      top = createTop()
      center = createCentre()
      bottom = createBottom()
      padding = Insets(10.0)
   }

   private fun createTop(): Node = TwoColumnGridPane().apply {
      addTextFieldRow(this, 0, viewModel.name)
      addDisplayRow(this, 1, "Gender:", viewModel.gender)
      addDisplayRow(this, 2, "Home Planet:", viewModel.homePlanet)
   }

   private fun createCentre(): Node? {
      return null
   }

   private fun createBottom(): Node {
      val searchButton = Button("Search").apply {
         onAction = EventHandler {
            isDisable = true
            searchHandler.accept { isDisable = false }
         }
      }
      return HBox(searchButton).apply {
         alignment = Pos.CENTER_RIGHT
      }
   }
}