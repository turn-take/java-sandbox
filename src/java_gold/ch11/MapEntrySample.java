package java_gold.ch11;

import java.util.HashMap;
import java.util.Map;

public class MapEntrySample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Y", "A");
        map.put("X", "a");
        map.entrySet().stream()
                // Map.EntryのcomparingByValueメソッドでValueによるソート機能を持ったComparatorを生成
                // デフォルトでは大文字小文字を区別しない
                //.sorted(Map.Entry.comparingByValue())
                //　String.CASE_INSENSITIVE_ORDERをcomparingByValueの引数に渡すことで大文字小文字を区別する。
                // String.CASE_INSENSITIVE_ORDERは大文字小文字を区別するComparator
                .sorted(Map.Entry.comparingByValue(String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
        map.entrySet().stream()
                // キーによるソート
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }
}
