package learning_java.inheritance;

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Lion extends Animal {
    void sleep () {
        System.out.println("Lion is sleeping");
    }
//    @Override
//    public void eat() {
//        System.out.println("Lion is eating");
//    }
}
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        Animal lion = new Lion();
//        lion.eat();
//         lion.sleep(); // This line would cause a compile-time error, as the reference type is Animal, which does not have a sleep() method.

        Lion lion1 = new Lion();
        lion1.eat();
        lion1.sleep();

        Lion animal1 = (Lion) lion; // Downcasting
        animal1.sleep(); // Now we can call sleep() method on animal1, as it is of type Lion
    }
}
