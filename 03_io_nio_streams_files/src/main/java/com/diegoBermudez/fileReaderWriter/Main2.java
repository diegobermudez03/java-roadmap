package com.diegoBermudez.fileReaderWriter;


import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        //the bridge classes used are InputStreamReader and OutputStreamWriter
        //usually if we're working with files, we'll work with a FileReader / Writer, which receives the File
        //and it will take care of creating the bridge class, but we can directly work with it
        String path = AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/fileReaderWriter/prueba.txt";
        File myFile = new File(path);
        Reader lector = new InputStreamReader(new FileInputStream(myFile));
        char[] cars = new char[100];
        lector.read(cars);
        System.out.println(new String(cars));

        //So what I'm trying to say, is that those bridge classes can be used also as the Reader/Writer directly, they by themselves do the
        //conversion from bytes to text
        System.out.println("------------------------------------------------");
        Reader lector2 = new BufferedReader(new InputStreamReader(new FileInputStream(myFile)));
        char[] cars2 = new char[100];
        lector2.read(cars2);
        System.out.println(new String(cars));

        //you may be thinking, why is this important, well, in sockets is really important, since it's used a lot directly the
        //bridge classes, so they are not only bridge classes but also the Reader/Writer itself
    }
}
