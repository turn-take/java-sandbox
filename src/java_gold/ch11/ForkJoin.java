package java_gold.ch11;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoin {
    public static void main(String[] args) {
        int data[] = {1,2,3,4,5};
        ForkJoinPool service = new ForkJoinPool();
        service.invoke(new AddAction(data, 0, data.length));
    }
}

class AddAction extends RecursiveAction {

    private static final int THRESHOLD_SIZE = 3; // 閾値
    private int start;
    private int end;
    private int[] numbers;

    public AddAction( int[] numbers, int start, int end) {
        this.start = start;
        this.end = end;
        this.numbers = numbers;
    }

    @Override
    protected void compute() {

        int total = 0;

        if(end - start <= THRESHOLD_SIZE) {
            for (int i = start; i < end; i++) {
                total += numbers[i];
            }
            System.out.println(Thread.currentThread().getName() + " : " + total + " ");
        } else {
            new AddAction(numbers, start + THRESHOLD_SIZE, end).fork(); // 9

            // こっちが先に処理完了する。
            // forkメソッドのオーバーヘッドによるもの？
            new AddAction(numbers, start, Math.min(end, start + THRESHOLD_SIZE)).compute(); // 6
        }
    }
}
