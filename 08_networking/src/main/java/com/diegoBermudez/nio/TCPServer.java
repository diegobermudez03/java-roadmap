package com.diegoBermudez.nio;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocketChannel serverChannel = ServerSocketChannel.open();
            Selector selector = Selector.open()) {
            serverChannel.configureBlocking(false); //configure so that the server channel is non blocabñe
            serverChannel.bind(new InetSocketAddress(Inet4Address.getLoopbackAddress(), 4000));
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);   //the option is of what type of operations
            //will the selector register to and keep track of
            while(true){
                int nKeys= selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                for(SelectionKey sk: keys){
                    if(sk.isAcceptable()){
                        SocketChannel newSocket = serverChannel.accept();
                        //if we want some sockets to be blockable, we could set it, in this case, since they are not
                        //if we do any read or write operation, and there's no data, it will inmediatly return 0 and continue
                        //if it was blockable, then it would stop until there's data
                        newSocket.configureBlocking(false);
                        //we can perform operation to see to what selector register it, if we want to apply any logic

                        //we can add an attchment to a key, which is an object, and we can attach any object we want, we could
                        //attach the specific Buffer we want to use for all the messages of that client
                        newSocket.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(1024));
                        //Since the options are bits, then we can use bit oprations to apply manu

                        System.out.println("CLIENT CONNECTED: " + ((InetSocketAddress)newSocket.getRemoteAddress()).getPort() + "\n");
                    }
                    else if(sk.isReadable()){
                        SocketChannel canal = (SocketChannel) sk.channel();
                        System.out.println("Message from: " + ((InetSocketAddress)canal.getRemoteAddress()).getPort() + "\n");
                        ByteBuffer bytesReaded = (ByteBuffer) sk.attachment();
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
                    else if(sk.isWritable()){
                        SocketChannel canal = (SocketChannel) sk.channel();
                        ByteBuffer bytesWriter = ByteBuffer.wrap("Hola desde el server".getBytes(StandardCharsets.US_ASCII));
                        canal.write(bytesWriter);
                        //changes the selection option, once we write, we are not longer interested on that
                        sk.interestOps(SelectionKey.OP_READ);
                    }
                }
                keys.clear();
                //IMPORTANT, IN THIS CODE I DON'T CLOSE BOTH THE SOCKETS WITH CLIENTS OR THE SELECTOR
                //BUT I SHOULD, THE ONLY THING IS THAT IN THIS PROGRAM I DIDN'T DESIGN HOW TO EXIT, SO THAT'S WHY
            }
        }
    }
}
