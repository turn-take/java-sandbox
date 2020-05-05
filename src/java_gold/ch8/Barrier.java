package java_gold.ch8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barrier {
    public static void main(String[] args) {

        // バリアの生成
        // 第二引数にRunnableを渡すとバリアのトリップ時に最後にバリアに入ったスレッドによって実行される。
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println(Thread.currentThread().getName() + ": Run!"));

        Runnable r = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": start");
            try {
                Thread.sleep((int) (Math.random() * 5000));

                System.out.println(threadName + " :waiting...");
                // バリアで待機しているスレッドの数
                System.out.println(cyclicBarrier.getNumberWaiting());
                // バリアで待機
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + ": end");
        };

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
