package learning_java.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Emp> employees = new ArrayList<>();
        employees.add(new Emp(3));
        employees.add(new Emp(1));
        employees.add(new Emp(2));

        Collections.sort(employees);
        for (Emp e : employees) {
            System.out.println(e.getId());
        }
    }
}

class Emp implements Comparable<Emp> {
    private int id;

    public Emp(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Emp other) {
        return Integer.compare(this.id, other.id);
    }
}