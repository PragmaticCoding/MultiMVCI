package ca.pragmaticcoding.multimvci.starwars

import ca.pragmaticcoding.multimvci.starwars.api.API
import com.google.gson.JsonObject
import org.slf4j.LoggerFactory

class SwInteractor(private val viewModel: SwModel) {
   companion object {
      private val LOGGER = LoggerFactory.getLogger(SwInteractor::class.java)
   }

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
         LOGGER.debug("Planet: {}", planet)
      } catch (e: Exception) {
         LOGGER.error("Lookup failed for '{}'", viewModel.name.value, e)
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