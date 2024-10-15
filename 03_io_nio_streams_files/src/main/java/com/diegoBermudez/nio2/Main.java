package com.diegoBermudez.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //creating directory
        Path p = Paths.get("C:\\Users\\Usuario\\Documents\\0 DEVELOPER CAREER\\pruebaNIO");
        if(Files.exists(p)) System.out.println("it exists");
        else{
            Path donePath = Files.createDirectory(p);
            System.out.println("Directory created " + donePath.toString());
        }
        //creating file
        Path file = Paths.get("C:\\Users\\Usuario\\Documents\\0 DEVELOPER CAREER\\pruebaNIO\\archivo.txt");
        if(Files.exists(file)) System.out.println("file exists");
        else{
            Path filePath = Files.createFile(file);
            System.out.println("file created at " + filePath.toString());
        }

        //reading from a file
        List<String> lineas = Files.readAllLines(file);
        for(String l: lineas){
            System.out.println(l);
        }

        //writing files
        Files.write(file, "DESDE NIO Y EL PROGRAMA".getBytes());
        lineas.add("SEGUNDA LINEA");
        lineas.add("TERCERA LINEA");
        lineas.add("CUARTA LINEA Y FINAL");
        Files.write(file, lineas, StandardOpenOption.APPEND);


        //copying files, even larger ones
        Path origin = Paths.get("C:\\Users\\Usuario\\Documents\\universidad\\Semestre 4\\Fundamentos ing\\Diapositivas\\ApisServlets.zip");
        Path destination = Paths.get("C:\\Users\\Usuario\\Documents\\0 DEVELOPER CAREER\\pruebaNIO\\pasted.zip");
        Files.copy(origin,destination);

        //move instead of copying
        Path origin2 = Paths.get("C:\\Users\\Usuario\\Documents\\universidad\\Semestre 4\\Fundamentos ing\\Diapositivas\\Diagrama de Arquitectura - Infraestructura 1 (2).zip");
        Path destination2 = Paths.get("C:\\Users\\Usuario\\Documents\\0 DEVELOPER CAREER\\pruebaNIO\\movido.zip");
        Files.copy(origin2,destination2);
    }
}
