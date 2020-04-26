package java_gold.ch1;

public interface Foo {
    void x();

    static void y() {}

    default void z() {}

    // インターフェース内のメンバークラスは暗黙的にstaticメンバークラスとなる
    class Innner{}
}

class Bar implements Foo{
    public void x() {}
}

class Hoge {

    public void method() {
        Bar bar = new Bar();
        Foo.y(); // staticメソッド呼び出し

        // staticメソッドはインターフェース型からしか呼べない
        //Bar.y();
        //bar.y();

        // デフォルトメソッドはインスタンスからしか呼べない
        //Foo.z();
        //Bar.z();

        bar.z();

        Foo bar2 = new Bar();

        bar2.z();

        // インターフェース型のインスタンスでもダメ
        //bar2.y();

        Foo.Innner innner = new Foo.Innner();
    }

}

// 抽象クラスには抽象メソッドが無くても良い
abstract class abSample implements Foo{
    void hoge() {}
}

class piyo extends abSample {
    @Override
    public void x() {

    }
}


