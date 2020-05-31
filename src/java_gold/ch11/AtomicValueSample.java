package java_gold.ch11;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicValueSample {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        for (int i = 0; i < 3; i++) {
            // getAndAccumulateメソッドで更新値と関数を指定してカスタマイズした計算を提供できる。
            System.out.print(ai.getAndAccumulate(2, Integer::sum));
        }

        System.out.println();

        AtomicReference<String> ar = new AtomicReference<>("Hoge");
        for (int i = 0; i < 3; i++) {
            // 更新値は関数の第二引数に適応される
            System.out.println(ar.accumulateAndGet("Fuga", String::concat));
        }
    }
}
