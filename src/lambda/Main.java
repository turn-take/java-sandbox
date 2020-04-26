package lambda;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> p1 = (s) -> s.equals("a");
        Predicate<String> p2 = (s) -> s.equals("b");
        Predicate<String> p3 = (s) -> s.equals("c");
        Predicate<String> p4 = (s) -> s.equals("a");

        Predicate[] parray = {p1,p2,p3,p4};

        final String a = "a";

//        TernaryOperator<Integer> t = (array , s) -> {
//           return Arrays.stream(array).filter(p -> p.test(s)).findFirst().ifPresent();
//        };

    }
}
