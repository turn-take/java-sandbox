package java_gold.ch2;

public class Paramator {
    // 引数のジェネリクスクラスをパラメータ化するときに境界ワイルドカードを使ったメソッド
    // 下限境界
    // Bを下限としている
    void doIt(Z<? super B> obj) {

    }
    // 上限境界
    // Bを上限としている
    void doIt2(Z<? extends B> obj) {

    }
}

class A{}
class B extends A{}
class C extends B{}
class Z<T>{}

// ジェネリクスクラスを継承する際はパラメータ化する必要がある
class extra1 extends Z<A>{}

// ジェネリクスクラスでジェネリクスクラスを継承する際にはクラスの型変数によってパラメータ化されるのでOK
//class extra2<A> extends Z<T>{}
