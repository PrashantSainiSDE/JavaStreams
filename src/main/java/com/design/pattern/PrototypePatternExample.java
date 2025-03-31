package com.design.pattern;

import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
}

// Concrete prototype class
class Circle1 implements Prototype {
    private int radius;

    public Circle1(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public Circle1 clone() throws CloneNotSupportedException {
        return (Circle1) super.clone(); // shallow copy
    }
}

// Prototype registry to manage prototypes
class PrototypeRegistry {
    private Map<String, Prototype> prototypes = new HashMap<>();

    public void addPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }

    public Prototype getPrototype(String key) throws CloneNotSupportedException {
        Prototype prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }
}

// Main class to test the prototype pattern
public class PrototypePatternExample {
    public static void main(String[] args) {
        // Create a prototype registry
        PrototypeRegistry registry = new PrototypeRegistry();

        // Add a circle prototype to the registry
        Circle1 circlePrototype = new Circle1(5);
        registry.addPrototype("Circle", circlePrototype);

        try {
            // Clone the circle prototype
            Circle1 clonedCircle = (Circle1) registry.getPrototype("Circle");

            // Print the radius of the cloned Circle
            System.out.println("Radius of cloned circle:" +
                    clonedCircle.getRadius());
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
