package com.diegoBermudez.objectsAndSerializable;

import java.io.Serializable;

public class Asignature implements Serializable {
    //Serialazible is only a mark class, the actual conversion and writing of the object
    //is done using reflection, so it uses this marker class to check if it's allowed to serialize or not
    //it could use annotation but due to legacy, polymorphism, and inheritance reasons it doesnt

    //implementing the serialVersion is a better practice than letting it to the JVM
    private static final long  serialVersionUID = 1L;

    private String asignatureName;
    private int numberStudents;
    private transient String bestPhrase;    //transient makes that this field won't be written

    public Asignature(String name, int numberStudents, String phrase){
        this.asignatureName = name;
        this.numberStudents = numberStudents;
        this.bestPhrase = phrase;
    }

    public String getAsignatureName() {
        return asignatureName;
    }
}
