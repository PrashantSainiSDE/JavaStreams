package com.design.pattern;

// Singleton class
class Singleton {
    // Static variable to hold the single instance of the class
    private static Singleton singleton;
    // private static Singleton singleton = new Singleton(); // Eager(Early) instantiation

    // Private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Single instance created");
    }

    // Static method to get the single instance of the class
    public static Singleton getInstance() {
        if (singleton == null ){
            System.out.println("Creating first instance");
            singleton = new Singleton();
          }
        System.out.println("Fetching instance");
            return singleton;
    }
}

// Main class to test the Singleton pattern
public class SingletonPatternExample {
    public static void main(String[] args) {
        //Get the only object available
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Check if both references point to the same instance
        System.out.println("Are both instacnes the same? " + (singleton1 == singleton2));
    }

}
