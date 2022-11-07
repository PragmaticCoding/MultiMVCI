package ca.pragmaticcoding.multimvci.starwars

import javafx.concurrent.Task
import javafx.event.EventHandler
import javafx.scene.layout.Region

class SwController {
   var view: Region
   var interactor: SwInteractor

   init {
      val viewModel = SwModel()
      view = SwViewBuilder(viewModel) { searchForCharacter(it) }.build()
      interactor = SwInteractor(viewModel)
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
}