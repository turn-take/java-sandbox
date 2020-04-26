package effectiveInterface.inerfaces;

@FunctionalInterface
public interface Sample2 {
    int doSomething3(int x, int y);

    // 抽象使ったテンプレートメソッド
    // ラムダ関数を呼び出せる
    default void template(int x, int y) {
        System.out.println(doSomething3(x, y));
    }

}
