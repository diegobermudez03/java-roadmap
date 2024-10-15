package com.diegoBermudez;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortScanning {

    public static void main(String[] args) throws IOException {
        InetAddress address = Inet4Address.getByAddress(new byte[]{127,0,0,1});
        Socket sock = null;
        for(int i = 0; i < 65535; i++){
            try {
                sock = new Socket(address, i);
                System.out.println("Port " + i + " is open");
                sock.close();
            } catch (IOException e) {
            }
        }
    }
}
