package java_gold.ch11;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateSample2 {
    public static void main(String[] args) {
        Predicate<Integer> p1 = i -> i % 2 == 0;
        Predicate<Integer> p2 = i -> i > 3;
        Arrays.asList(1,2,3,4,5).stream()
                // Predicateのandメソッドで二つのPredicateの論理積をとれる。
                // PredicateのnegateメソッドでPredicateの論理否定をとれる。
                .filter(p1.and(p2).negate())
                .forEach(System.out::print);

        System.out.println();

        Arrays.asList(1,2,3,4,5).stream()
                // Predicateのorメソッドで二つのPredicateの論理和をとれる。
                .filter(p1.or(p2))
                .forEach(System.out::print);

        long count = Stream.of("C", "A", "B", "A", "B", "C", "A")
                // PredicateのisEqualは引数で渡したオブジェクトとequalになるかを判定するPredicateを生成するstaticメソッド
                .filter(Predicate.isEqual("B"))
                // .filter(s -> s.equals("B")) と同一
                .count();
    }
}
