package java_gold.ch6;

import java.time.*;

public class Amount {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2020, Month.MAY, 1);

        Period period = Period.between(localDate1, localDate2);
        System.out.println(period.getDays());

        // LocalDateクラスの加・減算メソッドの引数にはTemporalAmountを引数に取るものがある。
        LocalDate localDate3 = localDate2.plus(period);
        System.out.println(localDate3);
        LocalDate localDate4 = localDate2.minus(period);
        System.out.println(localDate4);


        // 以下Duration
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, Month.MAY, 1, 0, 0);

        // DurationのbetweenメソッドはTemporalを引数に取る
        Duration duration = Duration.between(localDateTime1, localDateTime2);
        System.out.println(duration.getSeconds());

        LocalDateTime localDateTime3 = localDateTime2.plus(duration);
        System.out.println(localDateTime3);
        LocalDateTime localDateTime4 = localDateTime2.minus(duration);
        System.out.println(localDateTime4);
    }
}
