package java_gold.ch2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Compare {
    public static void main(String[] args) {
        Set<Product> set = new TreeSet<>();
        // Comparableを実装していないオブジェクトをソート機能付きコレクションに追加しようとすると実行時にClassCastException発生
//        set.add(new Product(110,"a"));
//        set.add(new Product(2,"b"));
//        set.add(new Product(31,"c"));
        //System.out.println(set);

        // ソート機能付きのコレクションはComparatorを引数に取るコンストラクタがある
        Set<String> stringSet = new TreeSet<>(new LengthComparator());
        stringSet.add("Adam");
        stringSet.add("Adammmmmmm");
        stringSet.add("Billy");

        // ComparatorのcomparingIntで代替可能
        // Set<String> stringSet2 = new TreeSet<>((s1,s2) -> s1.length() - s2.length());
        Set<String> stringSet2 = new TreeSet<>(Comparator.comparingInt(String::length));

        System.out.println(stringSet);

        // comparingの引数にComparableを返す関数
        Set<Product> products = new TreeSet<>(Comparator.comparing(p -> p.getName()));

    }
}

class Product implements Comparator<Product> {
    private int id;

    public InnerProduct getInnerProduct() {
        return innerProduct;
    }

    private InnerProduct innerProduct;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public class InnerProduct {
        private int innerInt;

        public InnerProduct(int innerInt) {
            this.innerInt = innerInt;
        }

        public int getInnerInt() {
            return innerInt;
        }
    }

    @Override
    // compareメソッドは比較対象のオブジェクト二つを取り、intを返す
    public int compare(Product o1, Product o2) {
        return o1.id - o2.id;
    }
}

class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
