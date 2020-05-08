package java_gold.ch4;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reduction {
    public static void main(String[] args) {
        // IntStreamの各種リダクション
        System.out.printf("個数: %d\n", IntStream.of(1,2,3).count());
        System.out.printf("平均: %.1f\n", IntStream.of(1,2,3).average().getAsDouble()); // Optional
        System.out.printf("最大: %d\n", IntStream.of(1,2,3).max().getAsInt()); // Optional
        System.out.printf("最小: %d\n", IntStream.of(1,2,3).min().getAsInt()); // Optional
        System.out.printf("合計: %d\n", IntStream.of(1,2,3).sum());

        Stream<String> stringStream1 = Stream.of("aa","b", "ccc");
        // オブジェクトのストリームの場合はmax or minメソッドにはComparatorを渡す
        stringStream1.max(Comparator.comparing(String::length));

        IntStream intStream1 = IntStream.rangeClosed(1,3);
        // streamのreduceメソッドで独自のリダクション処理を定義できる。引数にはBiOperatorを渡す
        // 第一引数にはデフォルト値を設定できる（しなくてもいい）
        //System.out.println(intStream1.reduce((x,y) -> x + y)); // 初期値なし
        System.out.println(intStream1.reduce(1, (x,y) -> x + y)); // 初期値あり
        //System.out.println(intStream1.reduce(1, Integer::sum)); // メソッド参照

        Stream<String> stringStream2 = Stream.of("a", "b", "c");
        String result = stringStream2.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        //String result = stringStream2.collect(() -> new StringBuilder(), (sb, s) -> sb.append(s), (sb1, sb2) -> sb1.append(sb2)).toString();
    }

    void sample() {
        BiFunction<String, Integer, String> biFunction = (s, i) -> s.concat(i.toString());
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);

        Stream<Integer> stream = Stream.of(1,2,3,4,5);

        stream.reduce("hoge", biFunction, binaryOperator);
    }
}
