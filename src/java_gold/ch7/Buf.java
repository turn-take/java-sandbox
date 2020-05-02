package java_gold.ch7;

import java.io.*;
import java.util.Arrays;

public class Buf {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("sample.txt");
            FileWriter fileWriter = new FileWriter("out.txt")) {

            int ch;
            // FileReaderのreadメソッドで1バイトずつint型で取得
            while ((ch = fileReader.read()) != -1) {
                // 一文字(1バイト)ずつ書き込み
                fileWriter.write((char) ch);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("sample.txt"));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"))){

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                // newLineメソッドで改行を出力する。
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(PrintWriter printWriter = new PrintWriter("out.txt")) {

            printWriter.println("Hallo");
            // プリミティブ型を出力できる
            printWriter.println(0.5);
            printWriter.println(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Consoleクラスは未対応のエディタが多い
        Console console = System.console();
        String line;
        if(console != null && (line = console.readLine()) != null) {
             line = console.readLine();
        }

        char[] passwd;
        // ConsoleクラスのreadPasswordメソッドでパスワードを入力待機するプロンプト文字列を設定できる。
        if(console != null && (passwd = console.readPassword("[%s]", "Password:")) != null) {
            // something to do

            // 読み取ったパスワードを空白文字で初期化する
            Arrays.fill(passwd, ' ');
        }
    }
}
