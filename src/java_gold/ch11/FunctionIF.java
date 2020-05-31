package java_gold.ch11;

@FunctionalInterface
public interface FunctionIF {
    void doIt();

    // 関数型IFの中にObjectクラスで宣言されているメソッドと同じシグネチャのメソッドがあってもそれは抽象メソッドとはみなされない。
    boolean equals(Object object);
}
