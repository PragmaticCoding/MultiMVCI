package ca.pragmaticcoding.multimvci.starwars.api;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetRequestRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetRequestRepository.class);
    private final API api;

    public GetRequestRepository(API api) {
        this.api = api;
    }

    public JsonObject getAll(String path, String searchquery) {
        JsonObject jsonObject = null;
        try {
            jsonObject = api.getBuilder(path, searchquery);
        } catch (Exception e) {
            LOGGER.error("Error on getAll", e);
        }
        return jsonObject;
    }

    public JsonObject innerRequest(String uri) {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject = api.innerRequest(uri);
        } catch (Exception e) {
            LOGGER.error("Error on innerRequest", e);
        }
        return jsonObject;
    }
}