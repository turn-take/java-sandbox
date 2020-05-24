package java_gold.ch11;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread(new MyRunnable());

        Thread[] threads = {t1, t2, t3};

        for (int i = 0; i < 3; i++) {
            threads[i].start();
        }
    }
}

class MyRunnable implements Runnable {

    private static AtomicInteger value = new AtomicInteger(0);

    @Override
    // synchronizedを付与して実行順序を制御する。
    public synchronized void run() {
        System.out.println(value.incrementAndGet());
    }
}
