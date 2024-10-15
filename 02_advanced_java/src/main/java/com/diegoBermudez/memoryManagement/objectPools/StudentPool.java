package com.diegoBermudez.memoryManagement.objectPools;

import java.util.*;

public class StudentPool {

    private static StudentPool pool = new StudentPool();

    private final Queue<Student> freeStudents = new LinkedList<>();
    private final Set<Student> usedStudents = new HashSet<>();

    private StudentPool(){
        Thread clearFreeStudents = new Thread(){
            @Override
            public void run(){
                    while (true) {
                        synchronized (pool) {
                            Iterator<Student> iterator = freeStudents.iterator();
                            int starting = freeStudents.size() / 2;
                            int counter = 0;
                            while (iterator.hasNext()) {
                                iterator.next();
                                if (counter >= starting) {
                                    iterator.remove();
                                }
                                counter++;
                            }
                        }
                        try {
                            Thread.sleep(7000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                }
            }
        };
        clearFreeStudents.setDaemon(true);
        clearFreeStudents.start();
    }

    public static StudentPool getInstance(){
        return pool;
    }

    public synchronized Student createStudent(String name, int age){
        Student stud;
        if(freeStudents.isEmpty()) {
            stud = new Student();
        }else{
            stud = freeStudents.poll();
        }
        stud.setAge(age);
        stud.setName(name);
        usedStudents.add(stud);
        return stud;
    }

    public synchronized void deleteStudent(Student student){
        usedStudents.remove(student);
        student.delete();
        freeStudents.add(student);
    }

    public void printInformation(){
        System.out.println("\nAvailable students: " + freeStudents.size());
        System.out.println("Occupied students: " + usedStudents.size());

    }

}
