package com.diegoBermudez.tryWithResources;


import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        //try with resources can be used for anything, not only exceptions, is a try block which contains resources to use inside
        //resources are objects that need to be closed at the end, such as files, so it will close them for us


        //sin try with resources
        File aPegar = new File(AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/tryWithResources/pegado.txt");
        if(!aPegar.exists()) aPegar.createNewFile();

        OutputStream escritor = new FileOutputStream(aPegar);
        InputStream lector = new FileInputStream(AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/tryWithResources/prueba.txt");
        byte[] bytes = new byte[100];
        int written = lector.read(bytes);
        escritor.write(bytes, 0, written);
        System.out.write(bytes);
        System.out.flush();
        lector.close();
        escritor.close();


        System.out.println("\n-------------------------------------------------------");
        //with try with resources
        File aPegar2 = new File(AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/tryWithResources/pegadoResources.txt");
        if(!aPegar2.exists()) Files.createFile(Paths.get(AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/tryWithResources/pegadoResources.txt"));

        try(
                OutputStream writer = new FileOutputStream(aPegar2);
                InputStream reader = new FileInputStream(AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/tryWithResources/prueba.txt")
        ){
            byte[] bytes2 = new byte[100];
            int written2 = reader.read(bytes2);
            writer.write(bytes2, 0, written2);
            System.out.write(bytes2);
            System.out.flush();
        }
        //here the streams are closed automatically thanks to the try with resources

    }
}
