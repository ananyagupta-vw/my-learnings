package LLD.L6_decorator_design_pattern;


// Decorator design pattern is a structural design pattern that allows you to wrap an existing object with additional layers of behaviors.
// It is used to extend a new functionality of an object at runtime without modifying its original code.
// Why is it used ? To prevent class explosion problem.
public class PizzaShop {
    public static void main(String[] args) {
        BasePizza farmhousePizza = new FarmhousePizza();
        System.out.println(farmhousePizza.getDescription() + " - Price: " + farmhousePizza.getPrice());

        BasePizza cheeseCornPizza = new CheeseCornPizza();
        System.out.println(cheeseCornPizza.getDescription() + " - Price: " + cheeseCornPizza.getPrice());

        // Adding Jalapeno Topping to Farmhouse Pizza
        BasePizza farmhouseWithJalapeno = new JalapenoTopping(farmhousePizza);
        System.out.println(farmhouseWithJalapeno.getDescription() + " - Price: " + farmhouseWithJalapeno.getPrice());

        // Adding Mushroom Topping to Cheese Corn Pizza
        BasePizza cheeseCornWithMushroom = new MushroomTopping(cheeseCornPizza);
        System.out.println(cheeseCornWithMushroom.getDescription() + " - Price: " + cheeseCornWithMushroom.getPrice());

        // Adding Paneer Topping to Farmhouse Pizza with Jalapeno
        BasePizza farmhouseWithJalapenoAndPaneer = new PaneerTopping(farmhouseWithJalapeno);
        System.out.println(farmhouseWithJalapenoAndPaneer.getDescription() + " - Price: " + farmhouseWithJalapenoAndPaneer.getPrice());

        FarmhousePizza farmhouse = new FarmhousePizza();
        // Adding Jalapeno Topping to Farmhouse Pizza
        BasePizza farmhouseWithJalapeno2 = new JalapenoTopping(farmhouse);
        System.out.println(farmhouseWithJalapeno2.getDescription() + " - Price: " + farmhouseWithJalapeno2.getPrice());

        BasePizza pizza = new CheeseCornPizza();
        pizza = new MushroomTopping(pizza);
        pizza = new PaneerTopping(pizza);
        pizza = new PaneerTopping(pizza);
        System.out.println(pizza.getDescription() + " - Price: " + pizza.getPrice());
    }
}

interface BasePizza {
    String getDescription();
    int getPrice();
}

class FarmhousePizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }

    @Override
    public int getPrice() {
        return 200;
    }
}

class CheeseCornPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Cheese Corn Pizza";
    }

    @Override
    public int getPrice() {
        return 130;
    }
}

abstract class ToppingDecorator implements BasePizza {
    BasePizza basePizza;

    public ToppingDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
}

class JalapenoTopping extends ToppingDecorator {
    public JalapenoTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + ", Jalapeno Topping";
    }

    @Override
    public int getPrice() {
        return basePizza.getPrice() + 30;
    }
}

class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + ", Mushroom Topping";
    }

    @Override
    public int getPrice() {
        return basePizza.getPrice() + 50;
    }
}

class PaneerTopping extends ToppingDecorator {
    public PaneerTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + ", Paneer Topping";
    }

    @Override
    public int getPrice() {
        return basePizza.getPrice() + 70;
    }
}



