package java_gold.ch11;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoin2 {
    public static void main(String[] args) {
        ForkJoinTask<Long> task = new SampleTask(1, 1000000);
//        task.fork();
//        System.out.println(task.join());


        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(task);
        System.out.println(task.join());


    }
}

class SampleTask extends RecursiveTask<Long> {

    private final int start;
    private final int end;

    public SampleTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        System.out.println(Thread.currentThread().getName() + " do.");
        int size = end - start;
        if (size <= 10000) {
            long sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }

        int split = start + size / 2;
        // 子スレッドに分岐して処理実行
        ForkJoinTask<Long> task1 = new SampleTask(start, split).fork();
        ForkJoinTask<Long> task2 = new SampleTask(split + 1, end).fork();
        // joinで非同期で結果取得
        return task1.join() + task2.join();

    }
}
