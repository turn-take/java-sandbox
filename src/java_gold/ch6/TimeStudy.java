package java_gold.ch6;

import java.time.*;
import java.time.temporal.TemporalField;
import java.util.Arrays;
import java.util.Date;

public class TimeStudy {
    public static void main(String[] args) {
        // 時差情報を含まない
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate : " + localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime : " + localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime : " + localDateTime);

        // 時差情報を含む
        // OffsetDateはない
        OffsetTime offsetTime = OffsetTime.now();
        System.out.println("offsetTime : " + offsetTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("offsetDateTime : " + offsetDateTime);

        // タイムゾーンを考慮
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime : " + zonedDateTime);

        // 年
        Year year = Year.now();
        System.out.println("year : " + year);

        // 年月
        YearMonth yearMonth = YearMonth.now();
        System.out.println("yearMonth : " + yearMonth);

        // 月ベースの日付
        MonthDay monthDay = MonthDay.now();
        System.out.println("monthDay : " + monthDay);

        // ofメソッドの第二引数（月）にはint型かMonth型が指定できる
        LocalDate localDate2 = LocalDate.of(2020, 1,1);
        LocalDate localDate3 = LocalDate.of(2020, Month.FEBRUARY, 1);

        Arrays.stream(Month.values()).forEach(month -> System.out.print(month + " "));
        System.out.println();
        Arrays.stream(DayOfWeek.values()).forEach(dayOfWeek -> System.out.print(dayOfWeek + " "));
        System.out.println();

        // parseの引数はISO-8601準拠
        System.out.println(LocalDate.parse("2020-01-31"));

        LocalDate d1 = LocalDate.of(2016, Month.APRIL,1);
        LocalDate d2 = LocalDate.of(2017, Month.APRIL,1);
        System.out.println(d1.isBefore(d2));
        System.out.println(d1.isAfter(d2));
        System.out.println(d1.isEqual(d2));

        // fromメソッドで別のTemporalAccessorの実装クラスから生成できる。
        LocalDate localDate4 = LocalDate.from(localDateTime);
        // 情報が欠けている場合は例外発生(DateTimeException) 情報量 小 ⇒ 大
        //LocalDateTime localDateTime1 = LocalDateTime.from(localDate);
        System.out.println(localDate4);

        // Offset～やZoned～からLocal～を生成すると時差情報やタイムゾーン情報は失われる
        OffsetDateTime offsetDateTime2 = OffsetDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now();
        System.out.println(offsetDateTime2);
        System.out.println(LocalDateTime.from(offsetDateTime2));
        System.out.println(zonedDateTime2);
        System.out.println(LocalDateTime.from(zonedDateTime2));

        // システムのタイムゾーン取得
        System.out.println(ZoneId.systemDefault());

        // Periodのbetweenメソッドで日付の差分取得
        // betweenメソッドでPeriodインスタンスが取得してget~で値をintで取得
        System.out.println(Period.between(localDate,localDate2).getDays());
        // Durationは時間
        //System.out.println(Duration.between(localDate,localDate2).getSeconds());

        // Instantはエポック秒
        System.out.println(Instant.EPOCH);
        System.out.println(Instant.now());
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(Instant.now().getEpochSecond());

        // Date ⇒ LocalDateTime
        Date date = new Date();
        // DateクラスのtoInstantメソッドでDateインスタンスからInstantインスタンスを生成できる。
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime2);

        // LocalDateTime ⇒ Date
        // DateクラスのfromメソッドにInstantを渡す
        Date date2 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date2);

        // エポックからの経過時間
        System.out.println(Instant.ofEpochMilli(1000000)); // ミリ秒
        System.out.println(Instant.ofEpochSecond(1000000)); // 秒
        System.out.println(Instant.ofEpochSecond(1000000,100)); // 秒 + ナノ秒

        // ZonedDateTimeのtoInstantメソッドでInstant生成
        System.out.println(ZonedDateTime.now().toInstant());
        // LLocalDateTimeの場合はタイムゾーン情報(ZoneOffset)を付与
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.MIN));
    }
}
