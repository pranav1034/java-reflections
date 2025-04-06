package com.bridgelabz.javareflections.intermediateproblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@interface Author{
    String name();
}

@Author(name = "Pranav")
class Book{
    public void display(){
        System.out.println("Author of the book is: ");
    }
}
public class RetrieveAnnotations {
    public static void main(String[] args) {
        try{
            Class<?> cls = Class.forName("com.bridgelabz.javareflections.intermediateproblems.Book");
            Author author = cls.getAnnotation(Author.class);
            if (author != null) {
                System.out.println("Author: " + author.name());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
