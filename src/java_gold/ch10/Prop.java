package java_gold.ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Prop {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("hoge.properties")) {
            Properties properties = new Properties();
            // Propertiesインスタンスを作ってからloadにInputStreamを指定して読み込む
            properties.load(fileReader);

            // PropertiesはMapの実装クラスなのでforEachが使える
            properties.forEach((k,v) -> System.out.println(k + ":" + v));
            // listメソッドにPrintStream or PrintWriterを渡せば出力できる
            properties.list(System.out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
