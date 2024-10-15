package com.diegoBermudez.nio;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Selector;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        Scanner lector = new Scanner(System.in);
        DatagramChannel canal= DatagramChannel.open();
        canal.configureBlocking(false);
        SocketAddress serverAddress = new InetSocketAddress(Inet4Address.getLoopbackAddress(), 4000);
        while(true){
            System.out.println("Ingresa mensaje:");
            String mensaje = lector.nextLine();
            ByteBuffer bytes = ByteBuffer.wrap(mensaje.getBytes());
            canal.send(bytes, serverAddress);
        }
        //canal.close();
    }
}
