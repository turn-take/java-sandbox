package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EchoThread implements Runnable{
    private final Socket socket;

    public EchoThread(Socket socket) {
        this.socket = socket;
        System.out.println("接続されました "
                + socket.getRemoteSocketAddress());
    }

    public void run() {
        try (/**BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))**/
             DataInputStream dis = new DataInputStream(socket.getInputStream())){

            // 入力をバイト配列に格納
            byte[] b = new byte[1024];
            dis.read(b);

            // バイト配列をUTF-8文字列に変換
            String result = new String(b, StandardCharsets.UTF_8);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                // nothing to do
            }
            System.out.println("切断されました "
                    + socket.getRemoteSocketAddress());
        }
    }
}
