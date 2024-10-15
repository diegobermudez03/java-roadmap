package com.diegoBermudez.objectsAndSerializable;

import java.io.Serializable;
import java.util.List;

//public class Student implements  Externalizable
public class Student implements Serializable {

    //implementing the serialVersion is a better practice than letting it to the JVM
    private static final long  serialVersionUID = 1L;

    private static int numberStudents = 0;
    private List<Asignature> asignatures;
    private String name;
    private int age;
    private String userName;
    private String password;
    private double netWorth;
    private double currentMoney;

    public Student(List<Asignature> asignatures, String name, int age, String userName, String password, double netWorth, double currentMoney) {
        this.asignatures = asignatures;
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.netWorth = netWorth;
        this.currentMoney = currentMoney;
    }
/*
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(asignatures);
        out.writeInt(age);
        out.writeChars(userName);
        out.writeDouble(netWorth);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        asignatures = (List<Asignature>) in.readObject();
        age = in.readInt();
        userName = (String)in.readObject();
        netWorth = in.readDouble();
        currentMoney = 0D;
        password = "*********";

    }
*/
    @Override
    public String toString(){
        StringBuilder desc = new StringBuilder("\n\nName: " + name + " Age: "+ age + " Password: " + password + " Networh: " + netWorth);
        for(Asignature a: asignatures){
            desc.append("\n      " + a.getAsignatureName());
        }
        return desc.toString();
    }
}
