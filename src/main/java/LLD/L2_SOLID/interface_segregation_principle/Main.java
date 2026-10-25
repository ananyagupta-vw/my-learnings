package LLD.L2_SOLID.interface_segregation_principle;

// Interface Segregation Principle (ISP) states that no client should be forced to depend on methods it does not use.
// In other words, an interface should have only the methods that are relevant to the implementing class.
// This principle helps to keep the code clean and maintainable by avoiding large, monolithic interfaces that can lead to unnecessary dependencies and complexity.

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human is working");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }
}

class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}

public class Main {
    public static void main(String[] args) {
        Workable humanWorker = new Human();
        humanWorker.work();

        Eatable humanEater = new Human();
        humanEater.eat();

        Workable robotWorker = new Robot();
        robotWorker.work();
    }
}