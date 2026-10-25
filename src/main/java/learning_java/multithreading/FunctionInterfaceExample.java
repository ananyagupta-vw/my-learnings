package learning_java.multithreading;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterfaceExample {
    public static void main(String[] args) {
        // Predicate is a functional interface that takes one argument and returns a boolean value. It has a method called test() that takes an argument and returns a boolean value.
        Predicate<Integer> isAdult = age -> age >= 18;
        System.out.println(isAdult.test(20));
        System.out.println(isAdult.test(15));


        // Function is a functional interface that takes one argument and produces a result. It has a method called apply() that takes an argument and returns a result.
        Function<Integer, String> ageCategory = age -> {
            if (age < 13) {
                return "Child";
            } else if (age < 20) {
                return "Teenager";
            } else {
                return "Adult";
            }
        };
        System.out.println(ageCategory.apply(10));

        // Consumer is a functional interface that takes one argument and returns no result. It has a method called accept() that takes an argument and returns no result.
         Consumer<Integer> printAge = age -> System.out.println("Age: " + age);
         printAge.accept(25);

         // Supplier is a functional interface that takes no arguments and produces a result. It has a method called get() that takes no arguments and returns a result.
         Supplier<String> getName = () -> "Ananya";
         System.out.println(getName.get());
    }
}
