package java_gold.ch11;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class InstantAndLocalDate {
    public static void main(String[] args) {
        Instant instant = Instant.now();

        // Instant → LocalDateTime
        // ofInstantメソッド、第一引数にInstantオブジェクト、第二引数にZoneId
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // LocalDateTime → Instant
        // LocalDateTimeのatZoneメソッドにZoneIdを渡してZonedDateTimeに変換してtoInstantでInstantに変換
        Instant instant2 = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }
}
