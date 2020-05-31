package java_gold.ch11;

public class MethodRef2 {
    public static void main(String[] args) {
        // コンストラクタ参照でコンストラクタがオーバーロードされていたら暗黙的に該当する法になる。
        Bar bar = Foo::new;
        bar.doIt(10);

        // ↑と同じ
        Bar bar2 = i -> new Foo(i);
    }
}

interface Bar {
    Foo doIt(int i);
}

class Foo {
    Foo() {
        System.out.println("Foo");
    }

    Foo(int i) {
        System.out.println("Foo" + i);
    }
}
