package effectiveInterface.inerfaces;

/**
 * インターフェースではデフォルトメソッドでテンプレートメソッドを提供できる。
 * toString()やhashCode()といったメソッドはデフォルト実装できないので、もしデフォルト実装を持ちたいなら抽象クラスに記述するのがいい
 */
public interface Sample {

    int doSomething1(int x, int y);
    void doSomething2(int i);

    // 抽象メソッドを使ったテンプレートメソッド
    default void template(int x, int y) {
        int i = doSomething1(x,y);
        doSomething2(i);
    }
}
