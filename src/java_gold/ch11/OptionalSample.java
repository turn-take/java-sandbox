package java_gold.ch11;

import java.util.Optional;

public class OptionalSample {
    public static void main(String[] args) {
        //Optional<String> optional1 = Optional.of(null); // -> 例外発生
        Optional<String> optional2 = Optional.ofNullable(null); // -> OK 空のOptional

        System.out.println(optional2 == null); // -> false

        System.out.println(optional2.isPresent()); // -> false

        optional2.ifPresent(System.out::println); // 出力なし

        System.out.println(optional2.orElse("Else")); // -> Else

        assert false : "False";

    }
}
