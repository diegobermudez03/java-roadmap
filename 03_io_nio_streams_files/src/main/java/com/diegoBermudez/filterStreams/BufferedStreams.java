package com.diegoBermudez.filterStreams;

import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.*;

public class BufferedStreams {

    public static void main(String[] args) throws IOException {
        String path = AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/filterStreams/prueba.txt";
        InputStream fileStream = new FileInputStream(path);
        FilterInputStream lector = new BufferedInputStream(fileStream);
        System.out.println(lector.readAllBytes().toString());
        lector.close();
    }
}
