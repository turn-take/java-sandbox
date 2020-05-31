package java_gold.ch11;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class CompositeFunc {
    public static void main(String[] args) {
        IntUnaryOperator f1 = i -> i * 2;
        IntUnaryOperator f2 = i -> i + 2;

        IntStream.of(0,1,2)
                // FunctionのandThenメソッドで引数に指定した関数を後から実行
                .map(f1.andThen(f2))
                .forEach(System.out::print);

        System.out.println();

        IntStream.of(0,1,2)
                // Functionのcomposeメソッドで引数に指定した関数を先に実行
                .map(f1.compose(f2))
                .forEach(System.out::print);
    }
}
