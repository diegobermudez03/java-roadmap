package com.diegoBermudez.nio_files;


import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main2BufferTypes {

    public static void main(String[] args) throws IOException {
        Path file = Paths.get(AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/nio_files/types.dat");
        if(!Files.exists(file)) createAndWrite(file);

        try(FileChannel lector = FileChannel.open(file, StandardOpenOption.READ)){
            ByteBuffer bytesBuffer = ByteBuffer.allocate(8);
            ByteBuffer bytesBuffer2 = ByteBuffer.allocate(12);
            lector.read(new ByteBuffer[]{bytesBuffer, bytesBuffer2});
            bytesBuffer.flip();
            bytesBuffer2.flip();
            IntBuffer buff1 = bytesBuffer.asIntBuffer();
            IntBuffer buff2 = bytesBuffer2.asIntBuffer();
            while(buff1.hasRemaining()){
                System.out.println(buff1.get());
            }
            while(buff2.hasRemaining()){
                System.out.println(buff2.get());
            }
        }
     }

     private static void createAndWrite(Path file) throws IOException {
        Files.createFile(file);
        try(FileChannel writer = FileChannel.open(file, StandardOpenOption.WRITE)){
            IntBuffer numeros = IntBuffer.allocate(5);
            numeros.put(100000);
            numeros.put(2555255);
            numeros.put(3188888);
            numeros.put(10080);
            numeros.put(12);
            numeros.position(0);
            ByteBuffer bytesWrite = ByteBuffer.allocate(5 * Integer.BYTES);
            while(numeros.hasRemaining())
            {
                int aux = numeros.get();
                System.out.println("+" + aux);
                bytesWrite.putInt(aux);
            }
            bytesWrite.flip();
            writer.write(bytesWrite);
        }

     }
}
