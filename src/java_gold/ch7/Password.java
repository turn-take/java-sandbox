package java_gold.ch7;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Password {
    public static void main(String[] args) {
        Console console;
        char[] password;
        if((console = System.console()) != null &&
                // Console.readPasswordを使うことで画面に文字を表示すること無く読み取りが出来る。
                // 第一引数にフォーマット書式、第二引数にフォーマット書式に当てはめるオブジェクトを指定することで、プロンプトに待機文字列を出力できる。
                (password = console.readPassword("[%s]", "Password:")) != null) {
            System.out.println(password);
            Arrays.fill(password, ' ');
        }
    }
}
