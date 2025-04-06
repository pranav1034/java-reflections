package com.bridgelabz.javareflections.basicproblems;

import java.lang.reflect.Field;

class Person{
    private int age=20;
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try{
            Person person =new Person();
            Class<?> cls = person.getClass();
            Field field = cls.getDeclaredField("age");
            field.setAccessible(true);
            field.setInt(person,30);
            System.out.println("Age: " + field.getInt(person));

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
