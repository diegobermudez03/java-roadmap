package com.diegoBermudez.randomAccessFile;

import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/randomAccessFile/prueba.txt";
        File file = new File(path);
        if(!file.exists()) file.createNewFile();

        RandomAccessFile myRand = new RandomAccessFile(file, "rw");
        myRand.write("hola como estas tu el dia de hoy, yo estoy bien, muchas gracias por preguntar".getBytes());

        myRand.seek(16);
        myRand.write("mañana, como estas mañana?".getBytes());
        myRand.seek(0);
        System.out.println(myRand.readLine());
        long size = myRand.length();
        myRand.seek(size-1);
        myRand.write("continuing writing more text".getBytes());
        myRand.seek(10);
        byte[] arr = new byte[10];
        myRand.read(arr);
        System.out.write(arr);
        System.out.flush();
        myRand.close();
    }
}
