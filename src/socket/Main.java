package socket;

import socket.test.Client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Server server = new Server();

        service.execute(server);

        // 以下テスト用
//        ExecutorService testService = Executors.newCachedThreadPool();
//
//        while (true) {
//            testService.execute(new Client());
//        }
    }
}
