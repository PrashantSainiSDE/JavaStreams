package com.example.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

record Company(String name) {
    private void displayName() {
        System.out.println("Private method invoked to display company name:" + name);
    }
}

public class ReflectionExample {
    // Using reflection to set private field and invoke a private method
    public static void main(String[] args) {

       // Create an instance of Company
       Company company = new Company("Youtube");
       System.out.println("Company Name: " +company.name());

       // Change the name from Youtube to Ytube
        try {
            Field nameField = Company.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(company,"Ytube");
            System.out.println(company.name());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // Invoke the private method 'displayName'
        try {
            Method objMethod = Company.class.getDeclaredMethod("displayName");
            objMethod.setAccessible(true);
            objMethod.invoke(company);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
