package java_gold.ch8;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.*;

public class ForkJoinStudy {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        invoke();
        submit();
    }

    static void invoke() throws InterruptedException {
        // ForkJoinPoolの生成
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // ForkJoinPoolのinvokeメソッドで同期実行
        // computeメソッドの戻り値をそのまま取得
        Integer result = forkJoinPool.invoke(new MyTask());
        System.out.println("Main: OK");
        Thread.sleep(3000);
        System.out.println("Done:" + result);
    }

    static void submit() throws InterruptedException, ExecutionException {
        // ForkJoinPoolの生成
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // ForkJoinPoolのsubmitメソッドで非同期実行
        // 戻り値は結果をラップしたForkJoinTask<V>
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(new MyTask());
        System.out.println("Main: OK");
        Thread.sleep(3000);
        // ForkJoinTaskのgetで結果取得
        System.out.println("Done:" + forkJoinTask.get());
        // executeにRecursiveTaskを渡すことは出来る。
        //forkJoinPool.execute(new MyTask());
    }
}

class MyTask extends RecursiveTask<Integer> {

    @Override
    protected Integer compute() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyTask: OK");
        return 1;
    }
}
