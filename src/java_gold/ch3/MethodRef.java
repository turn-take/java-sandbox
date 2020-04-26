package java_gold.ch3;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class MethodRef {
    public static void main(String[] args) {

        // ラムダ式
        String s1 = "hoge";

        UnaryOperator<String> unaryOperator1 = str -> s1.concat(str);
        System.out.println(unaryOperator1.apply("fuga"));

        //s1 = "hogehoge";


        // メソッド参照
        String s2 = "foo";

        UnaryOperator<String> unaryOperator2 = s2::concat;
        System.out.println(unaryOperator2.apply("bar"));

        s2 = "foofoo";
        System.out.println(unaryOperator2.apply("bar"));
    }
}
