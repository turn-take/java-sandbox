package java_gold.ch11;

import java.util.ArrayList;
import java.util.List;

public class ListSample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        // replaceAllの引数にUnaryOperatorを渡すことで要素に対して関数を適応する。
        list.replaceAll(s -> s.concat("!"));

        System.out.println(list);

        list.stream().forEach(System.out::println);
        list.stream().forEach(System.out::println);
    }
}
