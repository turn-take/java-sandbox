package java_gold.ch11;

public class InnerSample {
    public static void main(String[] args) {
        // 内部クラスのprivateフィールドは内部クラスを宣言したクラスの中から参照可能
        System.out.println(new InnerSample().new Inner().value);
    }

    private int value = 5;

    class Inner {
        private int value = new InnerSample().value + 5;
    }
}
