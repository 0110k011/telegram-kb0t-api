package com.kb0t.api.telegram;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TelegramConnectionService {

    static final String API_URL = "https://api.telegram.org/bot";

    public static String connectToAPI(String token) throws Exception {

        try {
            System.out.println(token);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + token + "/getUpdates"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}
