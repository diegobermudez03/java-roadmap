package com.diegoBermudez.reflection;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Person juan = new Student("Juan Diego", 2003, 101, "Coding");
        Class<?> clazz = Class.forName("com.diegoBermudez.reflection.Student");
        System.out.println(clazz.getName());
        System.out.println(clazz.getMethods().length);
        System.out.println("------------------------------------------");


        for(Method m: clazz.getMethods()){
            System.out.println(m.getName());
        }

        System.out.println("------------------------------------------");
        System.out.println(juan.getClass().getName());
        Method[] todosMetodos = juan.getClass().getMethods();
        Method[] metodosPropios = juan.getClass().getDeclaredMethods();
        System.out.println("Todos los metodos, incluyendo heredados son: " + todosMetodos.length + " y los propios son: " + metodosPropios.length);
        System.out.println(juan.getClass().getSuperclass());
        recursive(juan.getClass());

        System.out.println("--------------------------------------------");
        Field[] camposPublicos = juan.getClass().getFields();
        Field[] todosCampos = juan.getClass().getDeclaredFields();
        System.out.println("Todos los atributos incluyendo heredados son: " +camposPublicos.length + " y los propios son: " + todosCampos.length);
        for (Field f: todosCampos){
            System.out.println(f.getName());
        }
        System.out.println("++++++++++++++++++");
        for(Field f: camposPublicos){
            System.out.println(f.getName());
        }


        System.out.println("-----------------------------------------");
        Constructor<?>[] cons = juan.getClass().getConstructors();
        for(Constructor<?> c: cons){
            System.out.println(c.getName());
        }
        System.out.println("+++++++++++++++++");
        cons = juan.getClass().getConstructors();
        for(Constructor<?> c: cons){
            System.out.println(c.getName());
        }

        System.out.println("--------------------------------------");
        Constructor<?>[] constructors = juan.getClass().getConstructors();
        Student stud = null;
        if(constructors[0] != null) stud = (Student) constructors[0].newInstance("gabriela", 2005, 1002, "read");
        System.out.println(stud);


        System.out.println("--------------------------------------");
        Method m = juan.getClass().getDeclaredMethod("greetings");
        m.invoke(juan);


        System.out.println("--------------------------------------");
        //accessing and modifying fields, even private
        System.out.println("before the code was: " + ((Student)juan).getCode());
        Field f = juan.getClass().getDeclaredField("code");
        f.setAccessible(true);
        f.set(juan, 2000);
        System.out.println("after the change: " + ((Student)juan).getCode() + " or lecture " + f.get(juan));

        System.out.println("------------------------------------");
        for(Method meth: juan.getClass().getDeclaredMethods()){
            if(meth.getParameters().length == 0){
                meth.invoke(juan);
            }
            else{
                Parameter[] p = meth.getParameters();
                if(p.length == 1 && p[0].getParameterizedType().getTypeName().equals("int")) meth.invoke(juan, 10);
            }
        }
    }

    private static void recursive(Class<?> superClass){
        if(superClass != null) {
            System.out.println("the class is: " + superClass);
            recursive(superClass.getSuperclass());
        }
    }
}
