package LLD.L4_strategy_design_pattern;

// Strategy Design Pattern is a type of behavioral design pattern that lets you define a family of interchangeable algorithms or behaviors
// and encapsulates each in separate classes, allowing to change the behavior of an object at runtime without modifying its code.

// Client
public class Main {
    public static void main(String[] args) {
        // Create a shopping cart with a credit card payment strategy
        ShoppingCart cart1 = new ShoppingCart(new CreditCardPayment());
        cart1.strategy.pay(); // Output: Paying with credit card

        // Create a shopping cart with a PayPal payment strategy
        ShoppingCart cart2 = new ShoppingCart(new PayPalPayment());
        cart2.strategy.pay(); // Output: Paying with PayPal
    }
}

// Context is the class that uses a Strategy to perform a specific behavior.
// It maintains a reference to a Strategy object and delegates the behavior to it.
class ShoppingCart {
    PaymentStrategy strategy;

    public ShoppingCart(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay() {
        strategy.pay();
    }
}

// Strategy is an interface that defines a common behavior for a family of algorithms.
interface PaymentStrategy {
    void pay();
}

// ConcreteStrategy is a class that implements the Strategy interface and provides a specific implementation of the behavior.
class CreditCardPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paying with credit card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paying with PayPal");
    }
}

