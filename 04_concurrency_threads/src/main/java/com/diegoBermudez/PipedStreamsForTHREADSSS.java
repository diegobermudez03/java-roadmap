package com.diegoBermudez;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamsForTHREADSSS {

    public static void main(String[] args) throws IOException {
        //Estas clases son especificas para comunicacion entre threads, no se usan para leer o escribir archivos, sino para comunicacion entre
        //threads por un canal de streams, fijate en los detalles del ejemplo, el comportamiento bloqueante y eso.
        final PipedOutputStream escritor = new PipedOutputStream();
        final PipedInputStream lector = new PipedInputStream(escritor);
        //lector.connect(escritor); tambien se puede
        Thread t1 = new Thread(){
            @Override
            public void run(){
                try {
                    System.out.println("Haciendo operacion desde thread escritor");
                    Thread.sleep(1500);
                    System.out.println("Terminando operacion desde trhead escritor, enviando informacion");
                    escritor.write(("holaaaaaa, te aviso que acabe").getBytes());
                    System.out.println("Ya le avise, hare otra operacion desde thread escritor");
                    Thread.sleep(4000);
                    System.out.println("le avisare otra cosa");
                    escritor.write("ya acabemos con el programa si?".getBytes());
                    System.out.println("desde thread escritor ya acabe");
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                try {
                    System.out.println("--------Desde thread lector voy a hacer algo");
                    Thread.sleep(1000);
                    System.out.println("--------Desde thread lector ya acabe, voy a esperar el mensaje");
                    byte[] arr = new byte[100];
                    lector.read(arr);
                    System.out.print("--------Veamos que recibi desde thread lector: ");
                    System.out.write(arr);
                    System.out.flush();
                    System.out.println("\n--------Hare otras cosas");
                    Thread.sleep(5000);
                    System.out.println("--------ya hice varias cosas, veamos si hay algo para mi");
                    byte[] mensaje2 = new byte[10];
                    lector.read(mensaje2);
                    System.out.print("--------A ver el segundo mensaje: ");
                    System.out.write(mensaje2);
                    System.out.flush();
                    System.out.println("\n--------bueno, acabemos");
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t1.start();
        t2.start();
    }
}
