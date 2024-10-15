package com.diegoBermudez.objectsAndSerializable;


import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Object input and output streams are childs of FilterInput / Output streams, they convert streams of bytes into
        //objects, the serializable interface is only like an "annotation" in order to know if the class is available to be serialized
        Asignature a1 = new Asignature("structures", 15, "amo el mundo");
        Asignature a2 = new Asignature("biology", 15, "ael mundo es lindo");
        Asignature a3 = new Asignature("ciencse", 85, "amo el mundo");
        Asignature a4 = new Asignature("filosogia", 95, "amo el mundo");
        Asignature a5 = new Asignature("ingles", 14, "estoy feliz");
        Asignature a6 = new Asignature("español", 16, "amemos la felicidad");
        Asignature a7 = new Asignature("bases de datos", 75, "amo el mundo");
        Asignature a8 = new Asignature("ingenieira de sonido", 38, "esto es programacion");
        Asignature a9 = new Asignature("artes", 84, "que hago con mi vida");

        LinkedList<Asignature> clases1 = new LinkedList<>(Arrays.asList(a1, a2, a5, a7, a8));
        LinkedList<Asignature> clases2 = new LinkedList<>(Arrays.asList(a1, a2, a3, a4, a6,a9));
        Student s1 = new Student(clases1, "juan diego", 18, "diegob", "actuacion1", 900000D, 14D);
        Student s2 = new Student(clases2, "gabriela bonilla", 19, "gabs", "marmolp", 140000D, 14000D);

        File file = new File(AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/objectsAndSerializable/prueba.dat");
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream objectWriter = null;
       /* if(file.exists()) {
            objectWriter = new ObjectOutputStream(out) {
                @Override
                protected void writeStreamHeader() throws IOException {
                }
            };
        }else{
            objectWriter = new ObjectOutputStream(out);
        }*/
        if(file.exists()){
            file.delete();
            file.createNewFile();
        }
        objectWriter = new ObjectOutputStream(out);

        objectWriter.writeObject(s1);
        objectWriter.writeObject(s2);
        objectWriter.close();
        System.out.println("FILES WRITTEN, LET ME GO TO CHECK IF THEY WERE WRITTEN SUCCESFULLY");

        ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(file));
        while(true){
            Student aux = (Student) objectReader.readObject();
            if(aux ==null) break;
            System.out.println(aux);
        }



    }
}
