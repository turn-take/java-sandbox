package java_gold.ch11;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class LocalClass {
    public static void main(String[] args) {
        // ローカルクラスにstaticはできない
        class hoge {};
        assert true;
        assert(false);

        int x = 0;

        assert x==0;
        assert(x==0);

        int[] array = {0,1,2,3};
        IntStream intStream = Arrays.stream(array);

    }

    // クラス内のenumは暗黙的9にstaticなenumとなる
    private static enum X {

    }
}
