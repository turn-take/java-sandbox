package java_gold.ch11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComplexStream {
    public static void main(String[] args) {
        String s1 = "Red Blue Red Green";
        String s2 = "Green Red";

        Stream<String> stream = Stream.of(s1,s2);

        stream.flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

    }
}
