package java_gold.ch7;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PW {
    public static void main(String[] args) {
        // PrintWriterの生成時に出力先を指定するだけで出力ストリームできる
        try (PrintWriter pw = new PrintWriter("sample.txt")){
            pw.println("hoge");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
