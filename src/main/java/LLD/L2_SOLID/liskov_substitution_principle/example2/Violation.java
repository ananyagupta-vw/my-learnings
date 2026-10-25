package LLD.L2_SOLID.liskov_substitution_principle.example2;

public class Violation {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        System.out.println(vehicle.hasEngine()); // return true
        System.out.println(vehicle.numberOfWheels()); // return 2

        Vehicle car = new Vehicle();
        System.out.println(car.hasEngine()); // true
        System.out.println(car.numberOfWheels()); // 4

        Vehicle bicycle = new Bicycle();
        System.out.println(bicycle.hasEngine()); // false
    }
}

class Vehicle {
    int numberOfWheels() {
        return 2;
    }

    boolean hasEngine() {
        return true;
    }
}

class Motorcycle extends Vehicle {

}

class Bicycle extends Vehicle {

    @Override
    boolean hasEngine() {
        return false; // This violates the Liskov Substitution Principle because a Bicycle does not have an engine.
    }
}

class Car extends Vehicle {
    @Override
    int numberOfWheels() {
        return 4;
    }
}

