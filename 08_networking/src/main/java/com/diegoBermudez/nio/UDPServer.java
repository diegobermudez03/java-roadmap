package com.diegoBermudez.nio;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        try(DatagramChannel server = DatagramChannel.open()) {
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(Inet4Address.getLoopbackAddress(), 4000));
            Selector selectorServer = Selector.open();
            server.register(selectorServer, SelectionKey.OP_READ);
            while(true){
                selectorServer.select();
                Set<SelectionKey> keys = selectorServer.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while(iterator.hasNext()){
                        DatagramChannel dc  = (DatagramChannel) iterator.next().channel();
                        //but dc is the same server channel so x, we don't need the above line
                        ByteBuffer bb = ByteBuffer.allocate(1024);
                        InetSocketAddress client = (InetSocketAddress) server.receive(bb);
                        bb.flip();
                        System.out.println("CLIENT: " + client.getPort());
                        while(bb.hasRemaining()){
                            System.out.print((char)bb.get());
                        }
                        System.out.println("");
                        iterator.remove();
                }
            }
        }
    }
}
