package java_gold.ch11;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class UTC {
    public static void main(String[] args) {
        // UTCのDateTimeオブジェクト
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        // DateクラスのfromメソッドにInstantオブジェクトを渡すことでDateに変換できる。
        Date date = Date.from(zonedDateTime.toInstant());

    }
}
