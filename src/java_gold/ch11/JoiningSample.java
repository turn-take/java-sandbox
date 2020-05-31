package java_gold.ch11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningSample {
    public static void main(String[] args) {
        String str = Stream.of("java", "oracle", "1z0-009")
                // joiningには区切り文字、プレフィクス、サフィクスを指定できる。
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(str);

        String str2 = Stream.of("java", "oracle", "1z0-009")
                // joiningには区切り文字だけの指定できる。
                .collect(Collectors.joining(","));
        System.out.println(str2);
    }
}
