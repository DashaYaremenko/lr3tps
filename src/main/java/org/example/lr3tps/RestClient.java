package org.example.lr3tps;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClient {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/stations"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONArray jsonArray = new JSONArray(response.body());

        System.out.println("Список станцій:");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject station = jsonArray.getJSONObject(i);
            int id = station.getInt("id");
            String name = station.getString("nameStation");
            System.out.println("ID: " + id + ", Назва Станції: " + name);
        }
    }
}
