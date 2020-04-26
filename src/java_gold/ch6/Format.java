package java_gold.ch6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Format {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.BASIC_ISO_DATE;
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ISO_LOCAL_DATE;
        //DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        System.out.println(dateTimeFormatter1.format(localDateTime));
        System.out.println(dateTimeFormatter2.format(localDateTime));
        System.out.println(dateTimeFormatter3.format(localDateTime));
        //System.out.println(dateTimeFormatter4.format(localDateTime));

        DateTimeFormatter dateTimeFormatter5 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(dateTimeFormatter5.format(localDateTime));

        DateTimeFormatter dateTimeFormatter6 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(dateTimeFormatter6.format(localDateTime));
    }
}
