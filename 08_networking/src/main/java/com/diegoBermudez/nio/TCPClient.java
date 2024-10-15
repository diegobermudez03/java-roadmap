package com.diegoBermudez.nio;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Scanner lector = new Scanner(System.in);
        //Obviously we could use only NIO on the server and IO on the client, usually the client can be blocking
        //but for this example we'll use also NIO here
        InetAddress serverAddress = Inet4Address.getByAddress(new byte[]{127,0,0,1});
        InetSocketAddress serverSocketAddress = new InetSocketAddress(serverAddress, 4000);
        Selector selector = Selector.open();
        //we could directly connect when creating, but only to use also the Connection key, we'll do it in two steps
        //SocketChannel servidor = SocketChannel.open(serverSocketAddress);
        SocketChannel servidor = SocketChannel.open(serverSocketAddress);
        servidor.configureBlocking(false);
        servidor.register(selector,  SelectionKey.OP_WRITE | SelectionKey.OP_READ);
        while(true){
            int nkeys = selector.select(2000);
            Set<SelectionKey> keys = selector.selectedKeys();
            for(SelectionKey sk: keys){
                if(sk.isConnectable()){
                    System.out.println("CONNECTED SUCCESFULLY");
                }
                else if(sk.isReadable()){
                    SocketChannel canal = (SocketChannel) sk.channel();
                    System.out.println("Message from server: ");
                    ByteBuffer bytesReaded = ByteBuffer.allocate(1024);
                    int readed = 0;
                    while(true){
                        readed = canal.read(bytesReaded);
                        bytesReaded.flip();
                        while(bytesReaded.hasRemaining()){
                            System.out.print((char)bytesReaded.get());
                        }
                        if(readed<1024) break;
                    }
                }
            }
            keys.clear();
            if(servidor.isConnected()) {
                System.out.println("Write your message: ");
                String message = lector.nextLine();
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                System.out.println(servidor.write(buffer));
            }

        }

    }
}
