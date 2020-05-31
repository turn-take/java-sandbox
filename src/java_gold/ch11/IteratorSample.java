package java_gold.ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorSample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");

        Iterator<String> it = set.iterator();

        set.add("C");

        // Iteratorを取得した後に要素に変更を与えるとConcurrentModificationException発生
        while (it.hasNext()) {
            System.out.print(it.next());
        }

        set.forEach(System.out::print);
    }
}
