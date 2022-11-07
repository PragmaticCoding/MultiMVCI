package ca.pragmaticcoding.multimvci.starwars.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArgumentSwitcher {

    private static final API apiCalls = new API();
    private final GetRequestRepository repository = new GetRequestRepository(apiCalls);
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Printer printer = new Printer();

    public void switcher(String command, String searchquery) {

        JsonObject jsonObject;

        switch (command) {
            case "films" -> {
                jsonObject = repository.getAll("films", searchquery);
                JsonArray filmresults = jsonObject.getAsJsonArray("results");
                printer.printDetailsFilms(filmresults);
            }
            case "planets" -> {
                jsonObject = repository.getAll("planets", searchquery);
                JsonArray planetresults = jsonObject.getAsJsonArray("results");
                printer.printDetailsPlanets(planetresults);
            }
            case "starships" -> {
                jsonObject = repository.getAll("starships", searchquery);
                JsonArray starshipresults = jsonObject.getAsJsonArray("results");
                printer.printDetailsStarships(starshipresults);
            }
            default -> System.out.println(command + " is not a available command");
        }
    }
}