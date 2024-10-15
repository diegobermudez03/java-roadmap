package com.diegoBermudez.udpSockets;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        //in UDP since there's no connection, are the packets the ones who knows the IP of the server
        //not the socket itself
        System.out.println("please enter the number: ");
        int i = (new Scanner(System.in)).nextInt();

        DatagramSocket ds = new DatagramSocket();
        byte[] b = ("" + i).getBytes();
        InetAddress ia = InetAddress.getByAddress(new byte[]{127,0,0,1});   //the InetAddress instance has inside either an Inet4Address or Inter6Address which it wil use depending, but we can't use them directly, we use them through the InetAddress
        System.out.println();
        //or
        //InetAddress ia = InetAddress.getLocalHost();
        //InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(b,0, b.length,ia,4000);
        ds.send(dp);    //we send through the socket the packet, the packet knows where to go


        //receiving data
        byte[] b1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
        ds.receive(dp1);
        System.out.println(new String(b1, 0, dp1.getLength()));
        //or
        System.out.println(new String(dp1.getData(), 0, dp1.getLength()));
    }
}
