package com.diegoBermudez.httpClient;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //HttpClient was introduced in jdk 11, we could develop a HttpClient only by using sockets (low level)
        //or with HttpUrlConnection (not so low level
        //But this HttpClient class allows us a more abstract way to implement Http clients
        HTTPClient client = new HTTPClient();
        List<Todo> todos = client.findAll();
        todos.forEach((v)->System.out.println(v.title()));


        System.out.println("----------------------------------------");
        //posting
        String response = client.postTodo();
        System.out.println(response);

        System.out.println("----------------------------------------");
        //posting asynchronously
        client.posTodoAsync();
        System.out.println("Number of threads: " + Thread.currentThread().getName());
        System.out.println("Holi, despues de la llamada, main thread");
        Thread.sleep(3000);

    }
}
