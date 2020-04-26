package java_gold.ch2;

public class Gene {

    void method() {
        // 型引数には継承関係があっても異なる型はNG
        //Foo<Number> foo = new Foo<Integer>();

        // 配列は異なる型に代入できてしまう！
        Number[] numarr = new Number[1];
        Integer[] intarr = new Integer[1];
        numarr = intarr;

        // 型引数には配列も可
        // データ型を要素に持つ配列は参照型なので当然OK
        Foo<int[], int[]> foo = new Foo<>();

        // ジェネリクスクラスをパラメータ化する時には?を使える。
        Foo<?,?> foo2 = new Foo<>();
        // インスタンスの生成時にワイルドカードはNG
        //Foo<?,?> foo2 = new Foo<?,?>();

    }

    // ジェネリクスメソッドは引数の前に型パラメータ
    // T型を返すメソッド
//    <T> T doIt() {
//        //Some implementation that returns T
//    }

    // T型を受け取るメソッド
    <T> void doIt(T t) {

    }
}

// 型境界を利用することで型変数に制約を与える
// 型変数における型境界はextendsのみ
class Foo<T, U extends T /**, V super T **/> {
    //static T t;

    public void antipattern() {
        // 型変数の型のインスタンス生成はNG
        //T t = new T();

        // 型変数の型のstatic変数の宣言はNG
        //static T t;

        // 型変数の型を要素に持つ配列の生成はNG
        //T[] tArray = new T[1];

        Object obj = new Object();

        // 型変数の型のinstanceof演算はNG
//        if(obj instanceof T) {
//
//        }

        // 型変数の型の.classメソッドの利用はNG
        //Class<T> tClass = T.class;
    }

}

interface X {}

// インターフェースを使う型境界であってもextendsを使う
class Y<T extends X> {}
