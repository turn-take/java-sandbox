package staticField;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Main {

    public static final A a = new A();

    public static final Map<String, A> map = new HashMap<>();

    public static final Supplier<A> sup = A::new;
    // public static final Supplier<A> sup = () -> new A();

    static {
        map.put("A", new A());
    }

    public static void main(String[] args) {

        A a1 = a;
        a1.value++;
        System.out.println("a1.value = " + a1.value);

        A a2 = a;
        a2.value++;
        System.out.println("a2.value = " + a2.value);

        A a3 = map.get("A");
        a3.value++;
        System.out.println("a3.value = " + a3.value);

        A a4 = map.get("A");
        a4.value++;
        System.out.println("a4.value = " + a4.value);

        A a5 = sup.get();
        a5.value++;
        System.out.println("a5.value = " + a5.value);

        A a6 = sup.get();
        a6.value++;
        System.out.println("a6.value = " + a6.value);

    }

    static class A{
        public int value = 0;
    }
}
