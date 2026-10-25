package LLD.L2_SOLID.liskov_substitution_principle.example1;


// Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
// In other words, if class B is a subclass of class A, then we should be able to replace A with B without altering the desirable properties of the program (correctness, task performed, etc.).
// so in the below example, Bird interface is A and Flyable is B, so where ever we are using Bird interface, we should be able to use Flyable interface without any issues.
interface Bird {
    void eat();
}

interface Flyable extends Bird {
    void fly();
}

class Sparrow  implements Flyable {
    @Override
    public void eat() {
        System.out.println("Sparrow is eating");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin implements Bird {
    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        sparrow.eat();
        ((Flyable) sparrow).fly();

        Bird penguin = new Penguin();
        penguin.eat();
        // penguin.fly(); // This line would cause a compile-time error, as Penguin does not implement Flyable
    }
}
