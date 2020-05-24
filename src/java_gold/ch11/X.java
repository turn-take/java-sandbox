package java_gold.ch11;

public interface X {
    public void doIt(String s);
}

abstract class D implements X{
    // インターフェースの抽象クラスを抽象クラスでabstract宣言することができる。
    public abstract void doIt(String s);
}
