package java_gold.ch11;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class NestedLambda {
    public static void main(String[] args) {
        IntStream s1 = IntStream.of(1,2,3);
        // intを引数にとってIntUnaryOperatorを返す関数
        IntFunction<IntUnaryOperator> func = x -> y -> x + y;
        // IntStreamのmapメソッドはInuUnaryOperatorを引数にとる
        IntStream s2 = s1.map(func.apply(1));
        s2.forEach(System.out::print);
    }
}
