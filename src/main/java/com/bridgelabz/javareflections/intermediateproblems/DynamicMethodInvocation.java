package com.bridgelabz.javareflections.intermediateproblems;
import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter method to invoke: ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter second number: ");
            int b = scanner.nextInt();

            Class<?> cls = Class.forName("com.bridgelabz.javareflections.intermediateproblems.MathOperations");

            Object obj = cls.getDeclaredConstructor().newInstance();

            Method method = cls.getMethod(methodName, int.class, int.class);
            Object result = method.invoke(obj, a, b);
            System.out.println("Result: " + result);
            scanner.close();

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name. Available: add, subtract, multiply");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
