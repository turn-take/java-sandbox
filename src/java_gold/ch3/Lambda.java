package java_gold.ch3;

import java.util.function.*;

public class Lambda {
    public static void main(String[] args) {

        // intを返すSupplier
        // Supplier<Integer>
        IntSupplier intSupplier = () -> 1;

        // intを引数に取るPredicate
        // Predicate<Integer>
        IntPredicate intPredicate = i -> i > 0 ? true : false;

        // T型とU型の引数二つを取るPredicate
        BiPredicate<String, Integer> biPredicate = (s, i) -> s.length() == i ? true : false;

        // intを引数に取るConsumer
        // Consumer<Integer>
        IntConsumer intConsumer = i -> System.out.println(i);
        // IntConsumer intConsumer = System.out::println;

        // T型とU型の引数二つを取るConsumer
        BiConsumer<String, Integer> biConsumer = (s,i) -> System.out.println(s + i);

        // Objectとintを引数に取るConsumer
        // BiConsumer<T, Integer>
        ObjIntConsumer<String> objIntConsumer = (o, i) -> System.out.println(o + i);

        // intを引数に取るFunction
        // Function<Integer>
        IntFunction<String> intFunction = i -> String.valueOf(i);
        // IntFunction<String> intFunction = String::valueOf

        // T型の引数からintを返すFunction
        // Function<T, Integer>
        ToIntFunction<String> toIntFunction = s -> Integer.valueOf(s);
        //ToIntFunction<String> toIntFunction = Integer::valueOf;

        // int型の引数からdoubleを返すFunction
        // Function<Integer, Double>
        IntToDoubleFunction intToDoubleFunction = i -> Double.valueOf(i);

        // T型を引数に取るOperator（演算子）
        // Function<T,T>
        UnaryOperator<String> unaryOperator = s -> s + "a";
        //UnaryOperator<String> unaryOperator = UnaryOperator.identity();

        // int型を引数に取るUnaryOperator（単項演算子）
        // UnaryOperator<Integer>
        IntUnaryOperator intUnaryOperator = i -> -i;

        // T型二つを引数に取るOperator
        BinaryOperator<String> binaryOperator = (s1,s2) -> s1.concat(s2);

        // int型二つを引数に取るBinaryOperator（二項演算子）
        IntBinaryOperator intBinaryOperator = (a,b) -> a + b;
        IntBinaryOperator intBinaryOperator2 = Integer::max;

        // インスタンスを利用したメソッド参照
        String s1 = "hoge";
        UnaryOperator<String> unaryOperator2 = s1::concat;
        // UnaryOperator<String> unaryOperator2 = s2 -> s1.concat(s2);
        s1 = "fuga";

        BooleanSupplier booleanSupplier = () -> true;

        // 引数二つのintを返すFunction
        ToIntBiFunction<String, Integer> toIntBiFunction = (s,i) -> s.length() + i;

    }

    void nest() {
         IntFunction<IntUnaryOperator> func = x -> {
             return y -> x + y;
         };
    }
}
