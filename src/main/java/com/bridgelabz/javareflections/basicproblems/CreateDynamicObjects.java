package com.bridgelabz.javareflections.basicproblems;

class Student {
    public Student() {
        System.out.println("Student object created!");
    }

    public void display() {
        System.out.println("Hello from Student class.");
    }
}

public class CreateDynamicObjects {
        public static void main(String[] args) {
            try {
                // Load the class dynamically
                Class<?> cls = Class.forName("com.bridgelabz.javareflections.basicproblems.Student");

                // Create instance using reflection (no 'new' keyword)
                Object obj = cls.getDeclaredConstructor().newInstance();

                // Optionally, call a method to verify
                cls.getMethod("display").invoke(obj);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
