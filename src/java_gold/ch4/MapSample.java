package java_gold.ch4;

import java.util.stream.*;

import java.util.stream.Stream;

/**
 * Streamのmapメソッドのサンプル
 * サンプルなので実行時の動作保証なし
 */
public class MapSample {

    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("hoge", "fuga", "foo", "bar");

        // Stream<T> ⇒ IntStream
        // ToIntFunction
        IntStream intStream = stream1.mapToInt(s -> s.length());

        // IntStream ⇒ LongStream
        // IntToLongFunction
        LongStream longStream = intStream.mapToLong(i -> i);

        // IntStream ⇒ DoubleStream
        // IntToDoubleFunction
        DoubleStream doubleStream = intStream.mapToDouble(i -> i);

        // IntStream ⇒ Stream<T>
        // IntFunction
        Stream<String> stream2 = intStream.mapToObj(String::valueOf);
    }
}
