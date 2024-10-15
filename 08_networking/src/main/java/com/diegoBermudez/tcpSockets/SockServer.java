package com.diegoBermudez.tcpSockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SockServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server started");

        ServerSocket listener = new ServerSocket(4000);
        System.out.println("Server running on port 4000");

        Socket socket = listener.accept();
        System.out.println("Client connected");

        //Working directly with the SocketInputStream, as is an InputStream we could use buffered if we want
        //InputStream br = new BufferedInputStream(socket.getInputStream());
        InputStream br = socket.getInputStream();
        byte[] str = new byte[50];
        int bytesRead = br.read(str);
        String clientData = new String(str, 0, bytesRead);
        System.out.println("Client data: " + clientData);

        //Working with Reader, so it converts the bytes to text
     /*   BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String nuevaLinea = lector.readLine();
        System.out.println("\nclient data: " + nuevaLinea);*/

        //sending back data
        OutputStream os = socket.getOutputStream();
        os.write(clientData.substring(0,5).getBytes());
        os.flush();


        Thread.sleep(5000);
        socket.close(); //closing the socket with the client
        listener.close();   //closing from listening to incoming requests
    }
}
