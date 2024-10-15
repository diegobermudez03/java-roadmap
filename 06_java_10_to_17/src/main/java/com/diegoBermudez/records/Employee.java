package com.diegoBermudez.records;

import java.util.Objects;

public class Employee {

    private final String name;
    private final int employeeNumber;

    public Employee(String name, int employeeName) {
        this.name = name;
        this.employeeNumber = employeeName;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public boolean equals(Object o){
        if(o == null)return false;
        if(o == this) return true;
        if(getClass() == o.getClass()){
           Employee aux = (Employee) o;
           return aux.getEmployeeNumber() == this.employeeNumber && aux.getName().equals(this.name);
        }
        return false;
    }

    @Override
    public  int hashCode(){
        return Objects.hash(name, employeeNumber);
    }

    @Override
    public String toString(){
        return "EmployeeClass(name=" + this.name + ", employeenNumber=" + this.employeeNumber + ")";
    }
}
