package java_gold.ch11;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ExtendFunction {
    public static void main(String[] args) {
        BinaryOperator<Integer> op = (i1, i2) -> i1 * i2;
        BiFunction<Integer, Integer, Integer> func = op; // BinaryOperatorはBiFunctionのサブインターフェースなので代入可能
        System.out.println(func.apply(2,3));

        UnaryOperator<Integer> op2 = i -> i * 2;
        Function<Integer, Integer> func2 = op2; // UnaryOperatorはFunctionのサブインターフェースなので代入可能
        System.out.println(func2.apply(3));
    }
}
