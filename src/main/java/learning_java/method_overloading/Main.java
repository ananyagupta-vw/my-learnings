package learning_java.method_overloading;

class Animal {}

class Dog extends Animal {}

class Printer {
    void print(Animal a) {
        System.out.println("Animal");
    }

    void print(Dog d) {
        System.out.println("Dog");
    }
}

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Animal animal = new Animal();
        Dog dog = new Dog();

        printer.print(animal); // Output: Animal
        printer.print(dog);    // Output: Dog

        Animal animalRefDog = new Dog();
        printer.print(animalRefDog); // Output: Animal (method overloading, not overriding)
    }
}
