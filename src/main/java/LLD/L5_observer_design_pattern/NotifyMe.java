package LLD.L5_observer_design_pattern;

// Pull Model

import java.util.ArrayList;
import java.util.List;

public class NotifyMe {
    public static void main(String[] args) {
        Product product = new Product(0);

        Customer customer1 = new Customer("Ananya", product);
        Customer customer2 = new Customer("Riya", product);

        product.addObserver(customer1);
        product.addObserver(customer2);

        System.out.println("Product is out of stock. Customers will be notified when it is back in stock.");

        // Simulate some time passing before the product is back in stock
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Product is back in stock! Customers will be notified now.");
        product.setStock(10); // This will notify all observers

        product.setStock(9); // This will not notify observers since the product was already in stock
    }
}

// Observable
interface ProductObservable {
    void addObserver(CustomerObserver observer);
    void removeObserver(CustomerObserver observer);
    void notifyObservers();
    int getStock();
}

// Observer gets notified and, then it pulls the data it needs from the observable
interface CustomerObserver {
    void update();
}

// Concrete Observable
class Product implements ProductObservable {

    private int stock;
    private final List<CustomerObserver> observers = new ArrayList<>();

    public Product(int stock) {
        this.stock = stock;
    }

    public void setStock(int stock) {
        boolean wasOutOfStock = this.stock == 0;

        this.stock = stock;

        // Notify only when product becomes available
        if (wasOutOfStock && stock > 0) {
            notifyObservers();
        }
    }

    public int getStock() {
        return stock;
    }

    @Override
    public void addObserver(CustomerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CustomerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (CustomerObserver observer : observers) {
            observer.update();
        }
    }
}

// Concrete Observer
class Customer implements CustomerObserver {
    String name;
    private final ProductObservable product;

    public Customer(String name, ProductObservable product) {
        this.name = name;
        this.product = product;
    }

    @Override
    public void update() {
        // Pull the data it needs from the product
        int stock = product.getStock();

        if (stock > 0) {
            System.out.println(name + ": Product is back in stock! Stock: " + stock);
        } else {
            System.out.println("Product is still out of stock.");
        }
    }
}