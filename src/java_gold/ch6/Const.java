package java_gold.ch6;

import java.time.DayOfWeek;
import java.time.Month;

public class Const {
    public static void main(String[] args) {
        for(DayOfWeek dayOfWeek : DayOfWeek.values()) {
            System.out.print(dayOfWeek + " ");
        }
        System.out.println();
        for (Month month : Month.values()) {
            System.out.print(month + " ");
        }
    }
}
