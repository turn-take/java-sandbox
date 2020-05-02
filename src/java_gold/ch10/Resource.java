package java_gold.ch10;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Resource {
    public static void main(String[] args) {
        // getBundleメソッドの引数にLocaleオブジェクトを渡すことで特定のロケールを扱うリソース・バンドル取得
        //ResourceBundle resourceBundle = ResourceBundle.getBundle("HogeResource", Locale.JAPAN);

        // リソース・バンドルクラス利用の場合は、完全修飾クラス名指定
        ResourceBundle resourceBundle2 = ResourceBundle.getBundle("java_gold.ch10.MyBundle");
        System.out.println(resourceBundle2.getString("Key1"));

    }
}

// 独自のリソース・バンドルクラスを作るにはListResourceBundleを継承したクラスを宣言する
class MyBundle extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        // リソースの内容を二次元配列で生成する。
        return new Object[][] {
                {"Key1" , "Value1"},
                {"Key2" , "Value2"}
        };
    }
}
