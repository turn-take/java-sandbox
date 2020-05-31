package java_gold.ch11;

import java.util.*;

public class MapToList {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 3);
        map.put("B", 1);
        map.put("C", 2);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        // ArrayListのコンストラクタにCollectionオブジェクトを渡すことで渡した要素を持つListを生成
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);

        // Collectionsのsortメソッドでソート
        Collections.sort(entryList, (e1, e2) -> e2.getValue() - e1.getValue());

        System.out.println(entryList);
    }
}
