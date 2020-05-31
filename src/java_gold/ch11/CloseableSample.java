package java_gold.ch11;

import java.io.Closeable;
import java.io.IOException;

public class CloseableSample {
    public static void main(String[] args) {
        // try-with-resourceにはCloseable実装クラスでも可能
        try(Hoge hoge = new Hoge()) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Closeable実装クラス
// CloseableはAutoCloseableを継承したインターフェースなのでtry-with-resourceで使える
class Hoge implements Closeable {

    @Override
    public void close() throws IOException {
        System.out.println("close");
    }
}
