package java_gold.ch5;

import java.io.IOException;

public class ExceptionStudy {
    public static void main(String[] args) {

        try {

        }catch (Throwable e) {
            // ループしてネストした例外をすべて取り出す。
            while (e != null) {
                e.printStackTrace();
                e = e.getCause(); // Throwableを返す
            }
        }
    }

    static void doIt() throws Exception {
        try {

        }catch (Exception e) {
            // 新しいException(Throwable)のコンストラクタ引数に別のExceptionを渡すことで例外を再スローできる
            throw new Exception(e);
        }
    }
}
