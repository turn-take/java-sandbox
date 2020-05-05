package java_gold.ch7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IO {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("sample.txt"))) {
            for (int i = 0; i < 3; i++) {
                bufferedReader.skip(i);
                System.out.print((char) bufferedReader.read());
            }
            // markメソッドの引数はマークした後に読み取ることの出来る文字数の上限
            bufferedReader.mark(3);
            System.out.print(bufferedReader.readLine());
            bufferedReader.reset();
            System.out.print((char) bufferedReader.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
