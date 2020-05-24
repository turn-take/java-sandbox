package java_gold.ch11;

import java.util.HashSet;
import java.util.Set;

public class SetSample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("a"); // 重複した値を入れてもエラーにはならない

        System.out.println(set.size());
    }
}
