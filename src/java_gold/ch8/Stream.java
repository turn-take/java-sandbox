package java_gold.ch8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        Arrays.asList(1,2,3).parallelStream()
                .sequential() // 並列　⇒　順次
                .parallel() // 順次　⇒　並列
                .forEach(System.out::println);

        // 並列ストリームのfindAnyはいずれかの値が返ってくる。
        // 常に同じ値は返ってこない
        OptionalInt optionalInt = IntStream.of(1,2,3)
                .parallel()
                .findAny();
    }
}
