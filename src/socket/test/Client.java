package socket.test;

import java.io.*;
import java.net.Socket;

/**
 * ソケット通信テスト用のクライアント
 */
public class Client implements Runnable{

    public static final int PORT = 10000; //待ち受けポート番号

    public void run() {

        try (Socket s = new Socket("localhost", PORT);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))) {
            bw.write(Thread.currentThread().getName());
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}