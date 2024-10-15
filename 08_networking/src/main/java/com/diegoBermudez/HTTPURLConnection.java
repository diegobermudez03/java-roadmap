package com.diegoBermudez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPURLConnection {
    public static  void main(String[] args) throws IOException {
        //with URL connections we can represent a single http request response, we could create our own HTTP client using this

        URL url = new URL("https://www.youtube.com/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(false);
        connection.setRequestMethod("GET");
        //the request is sent once a method which requires it is called, like getResponseCode
        System.out.println("Codigo respuestA: " +connection.getResponseCode());
        BufferedReader lector = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = lector.readLine();
        while(line != null){
            System.out.println(line);
            line = lector.readLine();
        }

        //escribiendo
        System.out.println("-----------------------------------------");
        url = new URL("https://httpbin.org/post");
        HttpURLConnection message = (HttpURLConnection) url.openConnection();
        message.setDoOutput(true);
        message.setRequestMethod("POST");
        OutputStream escritor = message.getOutputStream();
        escritor.write(("hola como estas desde el server, este mensaje " +
                "no sigue ningun protocolo HTTP").getBytes());
        System.out.println("CODE: " + message.getResponseCode());
        System.out.println("Message: " + message.getResponseMessage());
    }
}
