package java_gold.ch2;

import org.omg.CORBA.INITIALIZE;
import org.omg.CORBA.WStringSeqHelper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStudy {
    public static void main(String[] args) {
        Map<String ,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        // keySetメソッドでKeyのセット取得
        Set<String> keySet = map.keySet();

        // valuesでValueのコレクション取得
        Collection<Integer> values = map.values();

        // MapのentrySetメソッドでMap.EntryオブジェクトのSetを取得
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // Map.EntryのgetKeyメソッドでキー取得
            entry.getKey();
            // Map.EntryのgetValueメソッドで値取得
            entry.getValue();

        }
    }
}
