package com.diegoBermudez;

import java.io.File;
import java.io.IOException;

public class AuxiliarObtenerPath {

    public static String obtenerPath(){
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
        return myPath.reverse().toString();
    }
}
