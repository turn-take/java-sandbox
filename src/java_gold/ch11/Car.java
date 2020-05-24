package java_gold.ch11;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Car {

    private int cno;
    private String name;

    public Car(int cno, String name) {
        this.cno = cno;
        this.name = name;
    }

    public String toString() {
        return cno + ":" + name;
    }

    public int getCno() {
        return cno;
    }
}

class Main {
    public static void main(String[] args) {
        // ソート付きコレクションにはComparableを渡さなくてもComparatorを渡すでもいい
        Set<Car> carSet = new TreeSet<>(Comparator.comparing(Car::getCno));
        carSet.add(new Car(10123, "Volkswagen"));
        carSet.add(new Car(10124, "Audi"));
        System.out.println(carSet);
    }
}
