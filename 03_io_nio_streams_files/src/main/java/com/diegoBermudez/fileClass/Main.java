package com.diegoBermudez.fileClass;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //all this way to get the absolute path is just to avoid using NIO, because this section is only for IO
        String currentPath = getCurrentPath();
        File myFile = new File(currentPath + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/fileClass/mi_archivo.blend"); //or with src\\main\\java\\io...
        //si solo se pasa el nombre del archivo, este se busca en la carpeta del proyecto
        if(myFile.exists()){
            System.out.println("ya existia, eliminando");
            myFile.delete();
        }
        try {
            if(myFile.createNewFile()) System.out.println("File created succesfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("------------------------------------");
        //file trasversal, para ir del directorio actual hacia adelante
        File fileTrasversal = new File("../../Empresas para trabajar.txt");
        if(fileTrasversal.exists()) System.out.println("hicimos trasversal");


        System.out.println("------------------------------------");
        //visitando archivos en directorios
        File directory = new File("../../../");
        llamadaRecursiva(directory, 0);
     }

     private static void llamadaRecursiva(File current, int nivel){
        if(current.isDirectory()){
            File[] subFiles = current.listFiles();
            StringBuilder space = new StringBuilder();
            for(int i = 0; i < nivel*2; i++) space.append(" ");
            for(File f: subFiles){
                System.out.println(space + "Archivo: " + f.getName());
                if(nivel < 3) llamadaRecursiva(f, nivel+1);
            }
        }
     }

    private static String getCurrentPath(){
        File myFile = new File("hola");
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String currentProject = myFile.getAbsolutePath();
        byte[] path = currentProject.getBytes();
        boolean foundFirstSlash = false;
        StringBuilder myPath = new StringBuilder();
        for(int i = path.length -1; i >= 0 ; i--){
            if(path[i] == 92) {
                path[i] = 47;
                foundFirstSlash = true;
            }
            if(foundFirstSlash)  myPath.append((char)path[i]);
        }
        myFile.delete();
        return myPath.reverse().toString();
    }
}
