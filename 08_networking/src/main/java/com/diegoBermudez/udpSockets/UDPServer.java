package com.diegoBermudez.udpSockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(4000);

        byte[] b1 = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b1, b1.length);

        ds.receive(dp);

        String received = new String(b1, 0, dp.getLength());
        System.out.println("data received: " + received);
        //or
        System.out.println("data received v2: " + new String(dp.getData(), 0, dp.getLength()));
        double result = Double.parseDouble(received) * Double.parseDouble(received) ;

        byte[] resultBytes = Double.toString(result).getBytes();
        System.out.println(result + " and " + Double.toString(result));
        InetAddress clientAddress = dp.getAddress();
        int clientPort = dp.getPort();
        dp = new DatagramPacket(resultBytes, resultBytes.length, clientAddress, clientPort );
        ds.send(dp);

    }
}
