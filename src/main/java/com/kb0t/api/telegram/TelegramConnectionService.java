package com.kb0t.api.telegram;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TelegramConnectionService {

    static final String API_URL = "https://api.telegram.org/bot";

    public String connectToAPI(String token, String params) throws Exception {

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + token + params))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonResponse json = gson.fromJson(response.body(), JsonResponse.class);

            if (!json.ok) {
                throw new Exception(json.description);
            }

            return response.body();

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}
