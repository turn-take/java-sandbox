package java_gold.ch4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 複数のHogeクラスのpriceフィールドのサマリを算出する。
 */
public class Flat {
    public static void main(String[] args) {
        List<Hoge> hogeList = new ArrayList<>();

        Hoge hoge1 = new Hoge(100);
        Hoge hoge2 = new Hoge(200);
        Hoge hoge3 = new Hoge(300);
        Hoge hoge4 = new Hoge(350);
        Hoge hoge5 = new Hoge(6000);

        hogeList.add(hoge1);
        hogeList.add(hoge2);
        hogeList.add(hoge3);
        hogeList.add(hoge4);
        hogeList.add(hoge5);

        Stream<Hoge> hogeStream1 = hogeList.stream();

        // mapでpriceフィールドを基にしたStream<Integer>に変換してreduceでリダクションする。
        int count1 = hogeStream1.map(Hoge::getPrice)
                .reduce(0, Integer::sum);
        System.out.println(count1);

        Stream<Hoge> hogeStream2 = hogeList.stream();

        // mapToIntでIntStreamにしてsumメソッドを使う。
        int count2 = hogeStream2.mapToInt(Hoge::getPrice)
                .sum();
        System.out.println(count2);
    }
}

class Hoge{
    private int price;

    public Hoge(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
