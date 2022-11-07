package ca.pragmaticcoding.multimvci.starwars

import javafx.beans.property.StringProperty
import javafx.concurrent.Task
import javafx.event.EventHandler
import javafx.scene.layout.Region

class SwLookupController(val planetNameProperty: StringProperty) {
   private val interactor: SwInteractor
   private val viewModel = SwModel()
   private val viewBuilder: SwLookupViewBuilder

   init {
      interactor = SwInteractor(viewModel)
      viewBuilder = SwLookupViewBuilder(viewModel) { searchForCharacter(it) }
      planetNameProperty.bind(viewModel.homePlanet)
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

   fun getView(): Region = viewBuilder.build()

}