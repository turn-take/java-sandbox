package java_gold.ch1;

public class Outer {
    public static void x() {
        // staticメソッドからはOuterクラスのインスタンスがないとInnerクラスのインスタンスの生成は不可
        // 非staticなメンバークラスはインスタンスメンバーだから
        //Inner inner = new Inner();

        Outer outer = new Outer();
        Inner inner = outer.new Inner();

        Inner inner2 = new Outer().new Inner();


        // staticなメンバークラスはそのままインスタンス生成可
        StaticInner staticInner = new StaticInner();
    }

    public void z() {
        // 非staticメソッドからはそのままインスタンスの生成出来る
        Inner inner = new Inner();
    }

    // 非staticなメンバークラスはインスタンスメンバー
    class Inner {
        public void y() {

        }
    }

    static class StaticInner {

    }
}

class foo {
    void a() {
        // 外部クラスからOuterクラスの非staticメンバークラス呼び出し
        // Outerクラスのインスタンスを生成してからInnerクラスのインスタンス生成
        Outer.Inner inner = new Outer().new Inner();

        // 外部クラスからOuterクラスのstaticメンバークラス呼び出し
        // Outerクラスのインスタンスを生成する必要は無い
        Outer.StaticInner staticInner = new Outer.StaticInner();
    }
}
