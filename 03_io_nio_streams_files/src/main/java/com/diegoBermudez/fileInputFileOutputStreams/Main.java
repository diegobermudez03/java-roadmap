package com.diegoBermudez.fileInputFileOutputStreams;

import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //writinggggggg
        String path = AuxiliarObtenerPath.obtenerPath();
        //todo lo basado en Streams envia informacion como bytes,

        FileOutputStream fos = null;
        File file = new File(path + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/fileInputFileOutputStreams/prueba.txt");
        try {
            if(!file.exists())file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            //tambien se puede pasar tipo File, y el append si no se pasa se toma negativo
            //ya que literal creo el file, seria mejor pasar de una el file, pero quiero que veas que se puede solo con la ruta
            //igual el FileOutputStream va a crear el archivo el mismo, asi que da la misma
            fos = new FileOutputStream(file, true);
            fos.write(74);
            String frase = "hola como estas tu\n yo siento que me siento feliz, o eso creo, no se \n ejjeje";
            fos.write(frase.getBytes());
            fos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                if(fos != null) fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        //readinggggggggg
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(file);
            byte[] todosBytes = new byte[fis.available()];
            //todos los mismos metodos de lectura que en el system, 1 byte, todos los bytes, un arreglo de bytes, offset y lenght...
            fis.read(todosBytes, 0, todosBytes.length/2);
            fis.skipNBytes(todosBytes.length/4);
            byte[] restOfBytes = fis.readAllBytes();
            System.out.write(todosBytes, 0, todosBytes.length/2);
            System.out.println("\n\ny los que sobraron son\n");
            System.out.write(restOfBytes);
            System.out.flush();

        } catch (IOException  e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
