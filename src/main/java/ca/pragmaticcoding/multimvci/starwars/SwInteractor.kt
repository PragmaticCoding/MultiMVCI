package ca.pragmaticcoding.multimvci.starwars

import ca.pragmaticcoding.multimvci.starwars.api.API
import com.google.gson.JsonObject

class SwInteractor(private val viewModel: SwModel) {
   private var person: JsonObject? = null
   private var planet: JsonObject? = null
   private var noDataFound = false

   @Throws(Exception::class)
   fun lookupPerson() {
      noDataFound = false
      try {
         val api = API()
         val people = api.getBuilder("people", viewModel.name.value)
         val thisPerson = people.getAsJsonArray("results")[0].asJsonObject
         person = thisPerson
         planet = api.getEntry(thisPerson.get("homeworld").asString)
         println("Planet: $planet")
      } catch (e: Exception) {
         e.printStackTrace()
         noDataFound = true
      }
   }

   fun updateModelAfterLookup() {
      if (!noDataFound) {
         viewModel.name.value = person!!["name"].asString
         viewModel.gender.value = person!!["gender"].asString
         viewModel.homePlanet.value = planet!!["name"].asString
      } else {
         viewModel.name.value = "Nothing Found"
         viewModel.gender.value = ""
         viewModel.homePlanet.value = ""
      }
   }
}