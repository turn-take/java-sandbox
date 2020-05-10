package java_gold.ch10;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleResource {
    public static void main(String[] args) {
        // リソースバンドルは完全修飾指定する。
        // 第二引数にLocale指定することでそのロケールのリソースバンドルが利用される。
        ResourceBundle rb = ResourceBundle.getBundle("java_gold.ch10.MyResource", Locale.US);
        System.out.println(rb.getString("locale"));
    }
}
