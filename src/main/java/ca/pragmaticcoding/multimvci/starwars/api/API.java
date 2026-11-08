package ca.pragmaticcoding.multimvci.starwars.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class API {

    private static final String BASE_URL = "https://swapi.dev/api/";
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .connectTimeout(TIMEOUT)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();

    private static final Gson GSON = new Gson();

    public JsonObject getBuilder(String path, String searchquery) throws Exception {
        String uri = BASE_URL + path + "/";
        if (searchquery != null) {
            uri += "?search=" + URLEncoder.encode(searchquery, StandardCharsets.UTF_8);
        }
        return getRequest(uri);
    }

    private JsonObject getRequest(String uri) throws IOException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri))
                .header("Accept", "application/json")
                .timeout(TIMEOUT)
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Request interrupted: " + uri, e);
        }
        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
        }
        return deserialize(response.body());
    }

    public JsonObject deserialize(String json) {
        return GSON.fromJson(json, JsonObject.class);
    }

    public JsonObject getEntry(String uri) throws Exception {
        return getRequest(uri);
    }

    public JsonObject innerRequest(String uri) throws IOException {
        return getRequest(uri);
    }
}
