package java_gold.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ListStudy {
    void method() {
        List<Integer> list = new ArrayList<>();
        // subListメソッドで範囲内のList取得
        List<Integer> subList = list.subList(0,1);
        // toArrayメソッドで配列に変換(戻り値はObject配列)
        Integer[] intArray = (Integer[]) list.toArray();
        // Listのremoveはオーバーロードされてる
        boolean isRemoved = list.remove(Integer.valueOf(1)); // Objectの場合はbooleanを返す
        Integer removed = list.remove(1); // インデックスを指定した場合は消去した要素を返す

        // ArraysクラスのstaticメソッドasListで配列をListにする
        List<Boolean> booList = Arrays.asList(true, false, true);

        // Arrays.asListで返ってくるListとArrayListは互換性が無いので以下のようなキャストは実行時にエラーとなる。
        ArrayList<Boolean> arrayList = (java.util.ArrayList<Boolean>) booList;

        // こっちはコンパイルエラー
        //java.util.ArrayList<Integer> arrayList = Arrays.asList(1,2,3);

        // どうしてもArrayListで使いたいなら引数に渡す
        //ArrayList<Boolean> arrayList = new ArrayList<>(booList);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays.asList(1,2,3);
    }

}
