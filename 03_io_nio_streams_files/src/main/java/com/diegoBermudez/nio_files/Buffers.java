package com.diegoBermudez.nio_files;

import java.nio.CharBuffer;

public class Buffers {
    public static void main(String[] args) {
        CharBuffer buff = CharBuffer.allocate(100);
        System.out.println("When creation");
        printInfo(buff);

        char[] letras = new char[]{'h','o','l','a',' ','c','o','m','o',' ', 'e','s','t','a','s'};
        buff.put(letras, 0,letras.length);
        System.out.println("\nAfter writing");
        printInfo(buff);

        //fliping so we can read
        buff.flip();
        System.out.println("\nAfter fliping");
        printInfo(buff);
        System.out.println("GETTING FULL ARRAY, THIS OPERATION DOESN'T MOVE THE POSITION");
        char[] frase = buff.array();
        for(int i = 0; i < frase.length; i++) System.out.print(frase[i]);

        System.out.println("\n\nAfter getting array");
        printInfo(buff);

        System.out.println("\nREADING 5 FIRST");
        for(int i = 0; i < 5;i++) System.out.print(buff.get());
        System.out.println("\n\nAfter reading 5");
        printInfo(buff);

        buff.rewind();
        System.out.println("\nRewind so that we can read again");
        printInfo(buff);

        System.out.println("\nREADING 8 NEXT");
        for(int i = 0; i < 8;i++) System.out.print(buff.get());

        //going back to writing
        buff.compact();     //so it doesn't delete what wasnt read
        System.out.println("\n\nAfter compact");
        printInfo(buff);
        letras = new char[]{' ', 'e', 'l', ' ', 'd', 'i', 'a', ' ', 'd', 'e', ' ', 'h', 'o', 'y'};
        buff.put(letras,0, letras.length);

        System.out.println("\nAfter writing more");
        printInfo(buff);

        System.out.println("CHANGING TO READ AGAIN:");
        buff.flip();
        printInfo(buff);


        System.out.println("\nREADING NEXT 10");
        for(int i = 0; i < 10; i++) System.out.print(buff.get());
        printInfo(buff);

        System.out.println("\n\nclear so that we go back to writing but deleting what wasn't read");
        buff.clear();
        printInfo(buff);

    }

    private static void printInfo(CharBuffer buffer){
        System.out.println("\n--------------------------------");
        System.out.println("Limit: " + buffer.limit());
        System.out.println("Cpacity: " + buffer.capacity());
        System.out.println("Position: " + buffer.position());
    }
}
