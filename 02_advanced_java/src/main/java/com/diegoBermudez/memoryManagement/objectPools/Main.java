package com.diegoBermudez.memoryManagement.objectPools;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StudentPool pool =  StudentPool.getInstance();
        Student juan = pool.createStudent("juan diego", 20);
        Thread.sleep(2000);
        Student magnolia = pool.createStudent("magnolia" , 50);
        Thread.sleep(2000);
        Student leonardo = pool.createStudent("leonardo", 52);
        Thread.sleep(2000);
        Student andres = pool.createStudent("Andres david", 25);
        Thread.sleep(2000);
        pool.printInformation();
        pool.deleteStudent(magnolia);
        pool.deleteStudent(leonardo);
        pool.printInformation();
        Student gabriela = pool.createStudent("gabriela", 19);
        Thread.sleep(2000);
        Student augusto = pool.createStudent("augusto", 20);
        pool.printInformation();
        //this part is for you to notice how now our previous variables reference the new students
        //is a problem to check in future proffesional implementation
        System.out.println(magnolia.toString());
        System.out.println(leonardo.toString());
        System.out.println(gabriela.toString());
        System.out.println(augusto.toString());
        pool.deleteStudent(augusto);
        pool.deleteStudent(gabriela);
        pool.deleteStudent(juan);
        pool.deleteStudent(andres);
        pool.printInformation();
        //in order to check that our second daemon thread is succesfully cleaning the available students
        Thread.sleep(8000);
        pool.printInformation();


    }
}
