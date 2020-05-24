package java_gold.ch7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileSample {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir"));
        // Fileオブジェクト内のディレクトリ内のエントリ一覧の文字列
        for (String f : file.list()) {
            System.out.println(f);
        }
        // Fileオブジェクト内のディレクトリ内のエントリ一覧のFileオブジェクト
        for (File f : file.listFiles()) {
            System.out.println(f);
        }

        try(FileReader fileReader = new FileReader("sample.txt")) {
            int i = fileReader.read();
            System.out.println(i);
            char ch = (char) i;
            System.out.println(ch);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("closed");
    }
}
