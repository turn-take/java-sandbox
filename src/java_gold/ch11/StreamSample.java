package java_gold.ch11;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSample {


    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("A","B","hoge","fuga");
        stringStream.collect(Collectors.joining());

        Stream<String> stringStream2 = Stream.of("A","B","hoge","fuga");
        stringStream2.collect(Collectors.mapping(String::length, Collectors.toList()));

        // StreamのgenerateにSupplierを渡すことでSupplierから要素を無限に生成するストリームを生成
        // limitで要素数に上限を設定
        Stream<Double> stream = Stream.generate(Math::random).limit(19);
        stream.forEach(System.out::println);

        // プリミティブ派生ストリームの場合はプリミティブ派生Supplier
        IntStream intStream = IntStream.generate(() -> 1).limit(10);
    }
}
