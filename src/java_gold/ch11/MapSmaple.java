package java_gold.ch11;

import java.util.HashMap;
import java.util.Map;

public class MapSmaple {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("A","A1");
        map1.put("B","B1");
        map1.put("C","C1");

        Map<String, String> map2 = new HashMap<>();
        map1.put("D","D1");
        map1.put("E","E1");
        map1.put("A","A2");

        //map1にmap2の要素をコピーして追加
        map1.putAll(map2);

        System.out.println(map1);

    }
}
