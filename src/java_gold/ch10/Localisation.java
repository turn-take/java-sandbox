package java_gold.ch10;

import java.util.Locale;

public class Localisation {
    public static void main(String[] args) {
        // デフォルトLocalオブジェクト所得
        Locale local = Locale.getDefault();
        System.out.println(local.getCountry());
        System.out.println(local.getLanguage());
        System.out.println(local.getVariant());

        // LocaleクラスのstaticメンバークラスのBuilderクラス
        Locale.Builder builder = new Locale.Builder();
        builder.setLanguage("cat");
        builder.setRegion("ES");
        // コンストラクタと違って国コードや言語コードの妥当性チェックが出来る。
        Locale locale = builder.build();
        // 簡潔に書ける。
        Locale locale2 = new Locale.Builder()
                .setLanguage("cat")
                .setRegion("ES")
                .build();

        // Localeクラスはよく使われる国や言語のLocalクラスの定数フィールドを持っている。
        Locale localeJap = Locale.JAPAN;
    }
}
