package java_gold.ch4;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collect {
    public static void main(String[] args) {

        // T型の要素の数をカウントする
        Stream<String> stringStream1 = Stream.of("a","b","c");
        System.out.println(stringStream1.collect(Collectors.counting()));

        // T型からkeyを作成してkey毎にグルーピングする
        Stream<String> stringStream2 = Stream.of("a","b","c");
        // groupingByメソッドの引数にkeyを指定するFunction<T,K>を渡す
        // collect実行でkey毎にT（集合の要素）をグルーピングしたマップ(Map<K,List<T>>)が返ってくる。
        System.out.println(stringStream2.collect(Collectors.groupingBy(String::toString)));

        // 文字列結合
        Stream<String> stringStream3 = Stream.of("a","b","c");
        System.out.println(stringStream3.collect(Collectors.joining()));

        // 引数のComparatorに従って要素の最大値のOptionalを生成する
        Stream<String> stringStream4 = Stream.of("aa","b","ccc");
        System.out.println(stringStream4.collect(Collectors.maxBy(Comparator.comparing(String::length))).get());
        // minもある
        //System.out.println(stringStream4.collect(Collectors.minBy(Comparator.comparing(String::length))).get());

        // reducingメソッドにBiOperatorを渡すことでリダクションを実行できる
        Stream<String> stringStream5 = Stream.of("a","b","c");
        // 第一引数に初期値も指定可
        System.out.println(stringStream5.collect(Collectors.reducing("hoge",String::concat)));

        // 要素をリストに格納
        Stream<String> stringStream6 = Stream.of("a","b","c");
        List<String> list1 = stringStream6.collect(Collectors.toList());
        list1.forEach(System.out::println);

        // 要素をセットに格納
        Stream<String> stringStream7 = Stream.of("a","b","c");
        Set<String> set1 = stringStream7.collect(Collectors.toSet());
        set1.forEach(System.out::println);

        // 要素の中の特定の値を合計する
        Stream<String> stringStream8 = Stream.of("a","b","c");
        // 合計する対象を指定するToDoubleFunction<T>
        System.out.println(stringStream8.collect(Collectors.summingDouble(String::length)));
    }
}
