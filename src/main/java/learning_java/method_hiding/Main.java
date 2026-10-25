package learning_java.method_hiding;

// method hiding occurs when a subclass defines a static method with the same name and signature as a static method in its superclass.
// In this case, the subclass's method hides the superclass's method, and the version of the method that gets called is determined by the reference type, not the object type.

class Parent {
    static void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.show(); // Output: Parent

        Child child = new Child();
        child.show(); // Output: Child

        Parent parentRefChild = new Child();
        parentRefChild.show(); // Output: Parent (method hiding, not overriding)

        Child childRefChild = new Child();
        childRefChild.show(); // Output: Child
    }
}
