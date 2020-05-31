package java_gold.ch11;

public interface Foo2 {
    // インターフェース内にabstractメソッドを記述可能
    abstract void x();

    // staticとabstractの併用はできない
    //abstract static void y();
}
