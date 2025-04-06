package com.bridgelabz.javareflections.advancedproblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

class Engine {
    public void start() {
        System.out.println("Engine started!");
    }
}

class Car {
    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }
}

class SimpleDIContainer {

    public static <T> T createInstance(Class<T> clazz) {
        try {
            // Create instance of the main class (e.g., Car)
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Loop through all fields to find ones marked with @Inject
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    // Create instance of the dependency (e.g., Engine)
                    Object dependency = field.getType().getDeclaredConstructor().newInstance();

                    // Make private field accessible
                    field.setAccessible(true);
                    field.set(instance, dependency); // Inject dependency
                }
            }

            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance with dependencies", e);
        }
    }
}

public class DependencyInjection {
    public static void main(String[] args) {
        Car car = SimpleDIContainer.createInstance(Car.class);
        car.drive();
    }
}
