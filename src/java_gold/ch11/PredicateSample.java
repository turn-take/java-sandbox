package java_gold.ch11;

import java.util.function.Predicate;

public class PredicateSample {
    public static void main(String[] args) {
        Predicate<String> p = StringFilter::test;
    }
}

interface StringFilter {
    public static boolean test(String s) {
        return s.contains("n");
    }
}
