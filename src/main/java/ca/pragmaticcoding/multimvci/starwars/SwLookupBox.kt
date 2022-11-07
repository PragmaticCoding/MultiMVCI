package ca.pragmaticcoding.multimvci.starwars

import ca.pragmaticcoding.widgetsfx.text.Labels
import javafx.concurrent.Task
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.Region
import javafx.scene.layout.StackPane

open class SwLookupBox : StackPane() {

   private val interactor: SwInteractor
   protected val viewModel = SwModel()

   init {
      interactor = SwInteractor(viewModel)
      children += buildView()
   }

   private fun searchForCharacter(postSearchAction: Runnable) {
      val searchTask: Task<Void?> = object : Task<Void?>() {
         @Throws(Exception::class)
         override fun call(): Void? {
            interactor.lookupPerson()
            return null
         }
      }
      searchTask.onSucceeded = EventHandler {
         interactor.updateModelAfterLookup()
         postSearchAction.run()
      }
      val searchThread = Thread(searchTask)
      searchThread.start()
   }

   private fun buildView(): Region = HBox(6.0).apply {
      children += Labels.prompt("Name:")
      children += TextField().apply {
         textProperty().bindBidirectional(viewModel.name)
      }
      children += Button("Search").apply {
         onAction = EventHandler {
            isDisable = true
            searchForCharacter { isDisable = false }
         }
      }
   }
}