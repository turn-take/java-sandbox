package java_gold.ch4;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CompareStudy {
    public static void main(String[] args) {
        // Comparatorのcomparingメソッドにソートキーを返すFunctionを引数に渡すことで独自のソート方式を定義できる。
        Set<Employee> set = new TreeSet<>(Comparator.comparing(Employee::getId));
        // comparingIntも使える
        // こっちの方が直感的に何で比較するのかが分かりやすい
        Set<Employee> set2 = new TreeSet<>(Comparator.comparingInt(Employee::getId));
        set.add(new Employee(3,"John"));
        set.add(new Employee(1,"Bill"));
        set.add(new Employee(2,"Eric"));
        System.out.println(set);
    }
}

class Employee {
    private int id;
    private  String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

