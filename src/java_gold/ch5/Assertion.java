package java_gold.ch5;

public class Assertion {
    public static void main(String[] args) {
        int x = 1;

        // assertは式を判定する
        assert x == 1;

        // メソッド呼び出しは式ではない
        //assert test();

        // assert 条件式 : 引数でAssertionError発生時に渡せる引数を指定できる
        assert x == 2 : "Error!";
    }

    boolean test() {
        return true;
    }
}
