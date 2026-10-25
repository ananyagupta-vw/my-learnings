package learning_java.composition;

// Composition is a design principle in object-oriented programming where a class is composed of one or more objects from other classes, rather than inheriting from them.
// This allows for greater flexibility and reusability of code, as well as better encapsulation and separation of concerns.
// In composition, the composed objects are typically used to provide specific functionality to the containing class, rather than being part of its inheritance hierarchy.
// Has-A relationship

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {
    // Car has an Engine (Has-A relationship)
    private Engine engine;

    public Car() {
        this.engine = new Engine();
    }

    public void start() {
        engine.start();
        System.out.println("Car started");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
    }
}
