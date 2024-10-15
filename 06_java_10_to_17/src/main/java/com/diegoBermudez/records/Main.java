package com.diegoBermudez.records;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("juan", 101);
        Employee e2 = new Employee("juan", 101);
        System.out.println(e1.equals(e2));
        System.out.println(e1);
        System.out.println(e1.getName());
        System.out.println(e1.getEmployeeNumber());

        System.out.println("------------------------------");
        //records are inmutable, the fields are final, they can't be changed
        EmployeeRecord er1 = new EmployeeRecord("juan", 101);
        EmployeeRecord er2 = new EmployeeRecord("juan", 101);
        System.out.println(er1.equals(er2));
        System.out.println(er1);
        System.out.println(er1.name());
        System.out.println(er1.employeeNumber());
        System.out.println(er1.nameInUpper());
        System.out.println(EmployeeRecord.recordVar);
        er1.doSomething();
    }
}
