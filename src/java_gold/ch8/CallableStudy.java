package java_gold.ch8;

import java.util.concurrent.*;

public class CallableStudy {
    // FutureのgetメソッドはExecutionException, InterruptedExceptionをスローする可能性がある
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new MyCallable());
        // Futureのgetメソッドはスレッドが完了するまで待機して、完了したら値を取得する。
        System.out.println(future.get());
    }
}

// Callable<T>の型引数はcallメソッドが返す型
class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "OK";
    }
}