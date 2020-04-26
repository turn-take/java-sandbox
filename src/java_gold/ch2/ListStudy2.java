package java_gold.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStudy2 {
    public static void main(String[] args) {
        Integer[] array = {1,2,3};
        // Arrays.asListには配列も渡せる
        // Arrays.asListで生成されたListの要素は基となった配列の要素と同じ参照
        List<Integer> list1 = Arrays.asList(array);

        // 元のListからは独立した新しいList
        ArrayList<Integer> list2 = new ArrayList<>(list1);

        // list1の各要素はarrayの各要素と同じ参照なのでlist1の要素に変更を与えるとarrayの対応する要素の参照にも変更が与えられる
        list1.set(0,2);
        //list1.remove(1);
        //list1.add(4);
        list2.add(4);

        // Arrays.asListで生成されたListでaddを呼び出すと実行時にエラー
        // Arrays.asListで生成されるListは固定長
        list2.remove(1);
        list2.set(0,3);
         //list1.add(4);

        list2.add(4);

        System.out.println(Arrays.toString(array));
    }
}
