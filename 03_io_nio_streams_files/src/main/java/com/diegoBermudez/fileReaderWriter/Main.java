package com.diegoBermudez.fileReaderWriter;


import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //these classes are classes focused on writing and reading characters, so they are ideal for .txt files
        //they allow us to avoid the conversion depending on the system used (UTF, ASCCI, ETC), they identify it and to the translation
        //they use internally the streams readers/writers, through bridges (OutputStreamWriter, InputStreamReader)

        String path = AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/fileReaderWriter/prueba.txt";
        File myFile = new File(path);
        if(!myFile.exists()) myFile.createNewFile();
        Writer escritor = new FileWriter(myFile, false);
        escritor.write("Hola como estas tu el dia de hoy, yo creo que estoy bien\n, jejejeje, sigamos con esto\nte parece?");
        escritor.close();
        Reader lector = new FileReader(myFile);
        char[] array = new char[100];
        lector.read(array);
        System.out.println(array);
        lector.close();

        //there are also buffered versions for these ones, they receive a Reader/Writer
        System.out.println("\n---------------------------------");
        Writer bufferEscritor = new BufferedWriter(new FileWriter(myFile));
        bufferEscritor.write("esto es desde el buffered, escribamos mucho contenido apra que el \n buffered quede asi super" +
                "lleno jejeje\n ,asi mas llentio mas mas mas mas\n, eso eso eso eso");
        bufferEscritor.close();

        BufferedReader bufferLector = new BufferedReader(new FileReader(myFile));
        String linea = bufferLector.readLine();
        while(linea != null){
            System.out.println(linea + "  SALTO DE LINEA");
            linea = bufferLector.readLine();
        }
        bufferLector.close();
    }
}
