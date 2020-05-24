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
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             BufferedReader br = new BufferedReader(new InputStreamReader(dis))){

            br.readLine();
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
