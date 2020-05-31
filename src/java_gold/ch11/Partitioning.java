package java_gold.ch11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Partitioning {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Charles", "Jackie", "Eduard");
        System.out.println(
                // CollectorsのpartitioningByメソッドでtrueとfalseに分割したMap<Boolean, List<T>>を返す
                stream.collect(Collectors.partitioningBy(s -> s.contains("ar")))
        );

        Stream<String> stream2 = Stream.of("Charles", "Jackie", "Eduard");
        System.out.println(
                // CollectorsのpartitioningByメソッドの第二引数にCollectorsオブジェクトを渡すことで可変コンテナを指定できる。
                stream2.collect(Collectors.partitioningBy(s -> s.contains("ar"), Collectors.mapping(String::length, Collectors.toSet())))
        );
    }
}
