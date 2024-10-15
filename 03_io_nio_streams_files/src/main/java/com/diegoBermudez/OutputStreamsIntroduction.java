package com.diegoBermudez;

import java.io.IOException;

public class OutputStreamsIntroduction {

    public static void main(String[] args) {
        //writing, sending only 1 byte, the parameter is really an int, not a byte, but I consider to use
        //a byte for this example (which internally will perform casting to int, so we know that we are actually
        //passing a byte
        for(byte i = -128; i < 127; i++) {
            System.out.write(i);
        }
        System.out.flush();    //to write right now, not wait until the buffer fills

        System.out.println("\n\n----------------------------------------------------------------");

        //using an array of bytes
        String stringFrase = "hola mundo";
        byte[] frase = stringFrase.getBytes();
        try {
            System.out.write(frase);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.flush();


        //using an array of bytes but with offset and lenght
        System.out.println("\n\n------------------------------------");
        System.out.write(frase,5, 4);
        System.out.flush();



    }
}
