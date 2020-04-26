package java_gold.ch4;

import java.util.*;
import java.util.stream.IntStream;

public class Mapping {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
                Arrays.asList ("Java", "Oracle"),
                Arrays.asList("Lambda", "Java")
        );

        // flatMapで入れ子構造のストリームを一つのストリームに変換できる
        list.stream()
                // 入れ子になっているList<String>から一つのStream<String>を生成
                //.flatMap(l -> l.stream())
                // メソッド参照
                .flatMap(Collection::stream)
                // distinctで重複要素を一つにする
                .distinct()
                .forEach(System.out::print);
        System.out.println();

        // flatMapToIntで任意の入れ子のstreamを一つのIntStreamに変換できる。
        IntStream intStream1 = list.stream()
                .flatMapToInt(l -> IntStream.of(l.size()));


        // map.merge
        // 第一引数のkeyに対応するvalueに第二引数で渡したvalueをマージした新たなvalueを返す関数を第三引数(BiFunction<V,V,V>)に取る。
        Map<String,String > map = new HashMap<>();
        map.put("A","B");
        map.merge("A","C", (v1,v2) -> v1.concat(v2));
        //　メソッド参照
        //map.merge("A","C", String::concat);
        // keyが存在しないかnullなら第三引数は実行されない
        map.merge("B","C", (v1,v2) -> v1.concat(v2));
        System.out.println(map);
    }
}
