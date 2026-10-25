package LLD.L2_SOLID.liskov_substitution_principle.example2;

public class Fix {
    public static void main(String[] args) {
        EngineVehicles vehicle = new EngineVehicles();
        System.out.println(vehicle.hasEngine()); // return true
        System.out.println(vehicle.getNumberOfWheels()); // return 2

        EngineVehicles car = new Truck();
        System.out.println(car.hasEngine()); // true
        System.out.println(car.getNumberOfWheels()); // 4

        Vehicles bicycle = new Cycle();
        System.out.println(bicycle.getNumberOfWheels()); // return 2
    }
}

class Vehicles {
    // Include generic methods
    public Integer getNumberOfWheels() {
        return 2;
    }
}

class EngineVehicles extends Vehicles{
    public boolean hasEngine() {
        return true;
    }
}

class Bike extends EngineVehicles {
}

class Cycle extends Vehicles {
}

class Truck extends EngineVehicles {
    @Override
    public Integer getNumberOfWheels() {
        return 4;
    }
}

