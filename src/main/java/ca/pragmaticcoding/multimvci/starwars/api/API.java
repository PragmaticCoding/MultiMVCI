package ca.pragmaticcoding.multimvci.starwars.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class API {

    public API() {
    }

    public JsonObject getBuilder(String path, String searchquery) throws Exception {
        HttpGet httpGet;
        if (searchquery == null) {
            httpGet = new HttpGet("https://swapi.dev/api/" + path + "/");
        } else {
            httpGet = new HttpGet("https://swapi.dev/api/" + path + "/?search=" + searchquery);
        }
        return getRequest(httpGet);
    }

    private JsonObject getRequest(HttpGet getRequest) throws IOException {
        getRequest.addHeader("accept", "application/json");
        try (var httpClient = HttpClients.createDefault()) {
            return httpClient.execute(getRequest, response -> {
                if (response.getCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getCode());
                }
                return deserialize(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));
            });
        }
    }

    public JsonObject deserialize(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, JsonObject.class);
    }

    public JsonObject getEntry(String uri) throws Exception {
        HttpGet httpGet = new HttpGet(uri);
        return getRequest(httpGet);
    }

    public JsonObject innerRequest(String uri) throws IOException {
        HttpGet httpGet = new HttpGet(uri);
        return getRequest(httpGet);
    }
}