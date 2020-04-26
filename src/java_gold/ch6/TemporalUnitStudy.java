package java_gold.ch6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class TemporalUnitStudy {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        // 指定した日時単位を減産
        LocalDateTime localDateTime2 = localDateTime.minus(10,ChronoUnit.DAYS);
        System.out.println(localDateTime2);

        // 指定した日時単位を加算
        LocalDateTime localDateTime3 = localDateTime.plus(3,ChronoUnit.HOURS);
        System.out.println(localDateTime3);

        // 指定した日時単位未満を切り捨て
        LocalDateTime localDateTime4 = localDateTime.truncatedTo(ChronoUnit.DAYS);
        System.out.println(localDateTime4);

        // 第一引数に指定した日時から第二引数に指定した日時単位での期間をlongで取得
        LocalDate localDate = LocalDate.of(2020,Month.JANUARY,1);
        LocalDate localDate2 = LocalDate.now();
        long term = localDate.until(localDate2, ChronoUnit.DAYS);
        System.out.println(term);

        LocalDate start = LocalDate.of(2020,Month.APRIL,1);
        LocalDate end = LocalDate.now();
        // ChronoUnit(TemporalUnit)のaddToメソッドで第一引数の日時に第二引数で指定された期間を加算
        // 日時に加算
        Temporal t = ChronoUnit.DAYS.addTo(start,5);
        System.out.println(t);
        // 月に加算
        Temporal t2 = ChronoUnit.MONTHS.addTo(t,5);
        System.out.println(t2);
        // betweenメソッドで差分をlongで取得
        long days = ChronoUnit.DAYS.between(start,end);
        System.out.println(days);

    }
}
