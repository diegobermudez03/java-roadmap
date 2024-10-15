package com.diegoBermudez;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.Date;

public class URLConnectionDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.w3schools.com/");

        URLConnection conn = url.openConnection();
        System.out.println("Content: " + conn.getContent());
        System.out.println("Expiration: " + new Date(conn.getExpiration()));
        System.out.println("Content type: " + conn.getContentType());
        System.out.println("Content lenght: " + conn.getContentLength());
    }
}
