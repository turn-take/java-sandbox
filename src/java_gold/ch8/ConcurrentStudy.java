package java_gold.ch8;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentStudy {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("a","hoge");
        map.put("b","fuga");
        map.put("c","foo");
        map.put("d","bar");

        // キーが無ければ第二引数に指定したデフォルト値を取得する。
        String value1 = map.getOrDefault("a", "default");

        // キーがまだ値と関連付けられていないなら第二引数で指定した値で関連付ける
        map.putIfAbsent("a", "absent");

        // 指定した値にキーがマッピングされている場合のみそのエントリーを削除する。
        boolean hasRemoved = map.remove("a", "hoge");

        // キーがマッピングされている場合のみそのキーのエントリーを第二引数の値で置換する。
        map.replace("a", "newValue");

        // 第二引数で指定した値にキーが現在マッピングされている場合のみ、そのキーのエントリーを置換する。
        map.replace("a", "hoge", "newValue");

        // すべてのエントリーが処理されるか、関数が例外をスローするまで、各エントリの値をそのエントリで指定された関数を呼び出した結果で置換
        map.replaceAll((k,v) -> k.concat(v));
    }
}
