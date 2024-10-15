package com.diegoBermudez;

import java.io.IOException;

public class InputStreamsIntroduction {

    public static void main(String[] args) {

        //reading only 1 byte
        try {
            int letra = System.in.read();
            System.out.write(letra);
            System.out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //reading 1 letter many times
        System.out.println("\n----------------------------------------");
        try{
            byte[] frase = new byte[15];
            for(int i = 0; i < 15; i++){
                frase[i] = (byte)System.in.read();
            }
            System.out.write(frase);
            System.out.flush();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        //reading all and storing what we can into an array
        System.out.println("\n----------------------------------------");
        try {
            byte[] frase2 = new byte[10];
            System.in.read(frase2);
            System.out.write(frase2);
            System.out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //last example
        try{
            while(true){
                byte letra = (byte)System.in.read();
                if(letra == '\n') break;
            }
            System.out.println("enter detected");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
