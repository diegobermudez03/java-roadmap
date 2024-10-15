package com.diegoBermudez.tcpSockets;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SockClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        String ip = "127.0.0.1";
        int port = 4000;
        Socket s = new Socket(ip, port);
        //or we could use InetAddress
        InetAddress server = Inet4Address.getByAddress(new byte[]{127,0,0,1});
        //Socket s2 = new Socket(server, port);
        //or we could use InetSocketAddress, which combines address and port
        InetSocketAddress addr = new InetSocketAddress(server, port);
        //Socket s = new Socket();
        //s.connect(addr);


        System.out.println("Conectado al server");

        String str = "Juan Diego";

        //working directly with the SocketOutputStream, with bytes
        OutputStream os = s.getOutputStream();
        os.write(str.getBytes());
        os.flush();
        System.out.println("Mensaje enviado");


        //working with a Writer, so it converts text to bytes
      /*  Thread.sleep(5000);
        Writer out = new OutputStreamWriter(s.getOutputStream());
        out.write("hola como estas desde el cliente");
        out.flush();
        System.out.println("Mensaje enviado");*/


        //receiving data now
       //Thread.sleep(5000);
        InputStream lector = s.getInputStream();
        byte[] bytes = new byte[50];
        int amount = lector.read(bytes);
        String leido = new String(bytes, 0, amount);
        System.out.println("\nserver data: " + leido);

        s.close();
    }
}
