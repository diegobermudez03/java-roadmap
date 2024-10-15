package com.diegoBermudez;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLConnectionContent {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://google.com");
        URLConnection con = url.openConnection();
        BufferedReader lector = new BufferedReader(new InputStreamReader((InputStream) con.getContent()));
        String line = lector.readLine();
        StringBuilder acum = new StringBuilder();
        while(line != null){
            acum.append(line);
            line = lector.readLine();
        }
        String[] palabras = acum.toString().split(" ");
        boolean bodyFound = false;
        for(String p: palabras){
            if(p.contains("body")) bodyFound= true;
            if(bodyFound) System.out.println(p + " ");
        }
        lector.close();
        System.out.println("-------------------------------------");
        System.out.println("allowed intecation?" + con.getAllowUserInteraction());
        System.out.println("can we read?" + con.getDoInput());
        System.out.println("can we write?" + con.getDoOutput());
        System.out.println("was it modified?" + con.getIfModifiedSince());
        System.out.println("uses cache?" + con.getUseCaches());
        System.out.println("get url: " + con.getURL());
        System.out.println("get content encoding: " + con.getContentEncoding());
        System.out.println("last modified: " + con.getLastModified());
        System.out.println("headers:");
        Map<String, List<String>> headers = con.getHeaderFields();
        headers.forEach((k, v)-> {
            System.out.println("HEADER: " + k);
            v.forEach(System.out::println);
            System.out.println("++++++++++++++");
        });
    }
}
