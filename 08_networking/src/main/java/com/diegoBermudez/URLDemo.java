package com.diegoBermudez;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.linkedin.com:443/in/alfonso-neil-jimenez-casallas-3208a120/?originalSubdomain=co");
        System.out.println("Port specified: " + url.getPort());
        System.out.println("Default port of URL: " + url.getDefaultPort());
        System.out.println("File : " + url.getFile());
        System.out.println("Path : " + url.getPath());
        System.out.println("Host: " + url.getHost());
        System.out.println("Protocol: " + url.getProtocol());

        System.out.println("----------------------------------------");
        String protocol = "https";
        String host = "google.com";
        int port = 2222;
        String file = "hello,worldparameters";
        URL urll = new URL(protocol, host, port, file);
        System.out.println("Port specified: " + urll.getPort());
        System.out.println("Default port of URL: " + urll.getDefaultPort());
        System.out.println("File : " + urll.getFile());
        System.out.println("Path : " + urll.getPath());
        System.out.println("Host: " + urll.getHost());
        System.out.println("Protocol: " + urll.getProtocol());
    }
}
