package learning_java.streams;

// A stream lets you process a collection of data without using a traditional loop.
// It allows you to perform operations like filtering, mapping, and reducing on the data in a more functional style.
// Streams can be sequential or parallel, and they can be created from various data sources like collections, arrays, or I/O channels.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers from the list
        List<Integer> evenNumbers = list.stream()
                .filter(n -> n % 2 == 0 && n > 5)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);

        // mapping the even numbers to their english word representation
        List<String> evenNumbersInWords = evenNumbers.stream()
                .map(n -> {
                    switch (n) {
                        case 6:
                            return "six";
                        case 8:
                            return "eight";
                        case 10:
                            return "ten";
                        default:
                            return "";
                    }
                })
                .collect(Collectors.toList());

        System.out.println(evenNumbersInWords);

        List<Integer> incBy5 = list.stream().map(n -> n + 5).collect(Collectors.toList());

        System.out.println(incBy5);

        List<Integer> incNumbersGreaterThan5by10 = list.stream().filter(n -> n > 5).map(n -> n + 10).collect(Collectors.toList());

        System.out.println(incNumbersGreaterThan5by10);

        List<Integer> numbers = Arrays.asList(50, 10, 30, 20);

        List<Integer> result = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);

        List<Integer> result2 = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(result2);

        int total = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(total);
    }
}
