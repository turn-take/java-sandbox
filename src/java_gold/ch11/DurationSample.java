package java_gold.ch11;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DurationSample {
    public static void main(String[] args) {
        // ChronoUnitのgetDurationでDurationオブジェクトを取得してそれを10倍している
        Duration d1 = ChronoUnit.YEARS.getDuration().multipliedBy(10);
        Duration d2 = ChronoUnit.DECADES.getDuration();

        // 上記二つのオブジェクトは等価となる。
        System.out.println(d1.equals(d2));
    }
}
