package lambda;

import java.util.function.Predicate;

public interface TernaryOperator<T> {

    T test(Predicate<String> predicate[], String target);

}
