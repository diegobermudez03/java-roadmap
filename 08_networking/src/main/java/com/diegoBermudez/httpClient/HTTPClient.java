package com.diegoBermudez.httpClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class HTTPClient {
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/todos";
    private HttpClient client;
    private ObjectMapper objectMapper;

    public HTTPClient() {
        //this.client = HttpClient.newHttpClient();
        //this.client = HttpClient.newBuilder().build();
        this.client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        this.objectMapper = new ObjectMapper();
    }

    public List<Todo> findAll() throws IOException, InterruptedException {
        //we could add headers in the chaining if we wanted
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        //the Body handler is the one that specifies the type of the body we're receiving, in this case String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), new TypeReference<>(){});
    }

    public String postTodo() throws IOException, InterruptedException {
        String todoJson = """
                "userId" : 1,\
                "title" : "title something", \
                "completed" : false\
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .POST(HttpRequest.BodyPublishers.ofString(todoJson))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public void posTodoAsync()
            throws IOException, InterruptedException {
        String todoJson = """
                "userId" : 1,\
                "title" : "title something", \
                "completed" : false\
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .POST(HttpRequest.BodyPublishers.ofString(todoJson))
                .build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        response.thenAcceptAsync((r)->{
           System.out.println("from the async: " + Thread.currentThread().getName());
           System.out.println(r.body());
       });
    }
}
