package java_gold.ch4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStudy {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0,10);
        // Stream<Integer> と IntStreamには互換性無し
        // Stream<Integer> integerStream = IntStream.range(0,10);

        List<String> stringList = Arrays.asList("a","b","c");
        // Iterable実装にはforEachがdefaultメソッドとしてあるのでstreamを作らずとも利用できる
        stringList.forEach(System.out::println);
        Stream<String> stringStream = stringList.stream();
        stringStream.forEach(System.out::println);
        // 終端操作は複数回あってもコンパイルエラーにはならないが例外が発生する。
        //stringStream.forEach(System.out::println);

        Map<Integer, String > map = new TreeMap<>();
        map.put(1,"A");
        map.put(2,"B");
        // MapのforEachの引数はkeyとvalue
        // つまりBiConsumer<K,V>を引数に取る
        // 内部的にはentrySetで取得したMap.EntryのSetを利用している
        map.forEach((k,v) -> System.out.println(k + v));

        // 配列からStreamの生成にはArraysクラスのstaticメソッドのstreamメソッドを使う
        Stream<String> stringStream2 = Arrays.stream(new String[]{"a", "b", "c"});
        // int型の配列を引数にした場合は、Stream<Integer>ではなくIntStreamが返ってくることに注意
        IntStream intStream2 = Arrays.stream(new int[]{1,2,3});

        int[] array = {1,2,3,4,5};
        // Arrays.streamメソッドは範囲指定できる
        IntStream intStream3 = Arrays.stream(array, 1,4);

        // 最後の値を含まないstream生成
        IntStream.range(1,5).forEach(System.out::print);
        System.out.println();
        // 最後の値を含むstream生成
        IntStream.rangeClosed(1,5).forEach(System.out::print);
        System.out.println();

        // Streamクラスのstaticメソッドのofで任意のオブジェクトからstream生成可
        String s1 = "hoge";
        Stream<String> stringStream3 = Stream.of(s1);
        String s2 = "fizz";
        String s3 = "buzz";
        // 可変長でも可
        Stream<String> stringStream4 = Stream.of(s1,s2,s3);
        Integer integer = 1;
        // 異なる型も可
        Stream<?> wildStream = Stream.of(s1,integer);

        // int型はIntStreamのofメソッドを使う
        IntStream intStream4 = IntStream.of(1,2,3);

        // streamのmatToIntメソッドでIntStreamにマッピングしたstreamを返す。
        IntStream intStream5 = stringStream4.mapToInt(String::length);
        // IntStreamのmapの引数はUnaryOperator
        intStream5.map(i -> i++);

        // streamのsortedメソッドでソート
        // デフォルトでは自然順序
        Arrays.asList(2,3,1).stream()
                .sorted()
                .forEach(System.out::print);
        System.out.println();
        // Comparatorを渡せばソート方式を変えられる
        Arrays.asList(2,3,1).stream()
                .sorted((i,j) -> j - i)
                .forEach(System.out::print);
        System.out.println();
        peek();

        IntStream intStream6 = IntStream.of(1,2,3);
        // findXXメソッドはOptionalを返す
        // IntStreamの場合OptionalIntを返す
        OptionalInt optionalInt = intStream6.findAny();

        IntPredicate p = i -> {
            System.out.print("even ");
            return i % 2 == 0;
        };

        boolean result = IntStream.of(1,2,3).allMatch(p);
        System.out.println(result);

    }

    void linesSample() {
        try (BufferedReader br = new BufferedReader(new FileReader(""))){
            // BufferedReaderのlinesメソッドでStream<String>を取得できる。
            Stream<String> stringStream = br.lines();

            Path path = Paths.get("");
            // FilesクラスのstaticメソッドのlinesでStream<String>取得できる。
            Stream<String> stringStream2 = Files.lines(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void peek() {
        Stream<String> stream = Stream.of("banana", "apple", "orange")
                .filter(e -> e.length() > 5)
                .peek(e -> System.out.print(e + " "))
                .map(String::toUpperCase)
                .peek(e -> System.out.println(e + " "));
        System.out.println("OK");
        stream.count();
    }
}
