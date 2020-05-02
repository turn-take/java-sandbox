package java_gold.ch8;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {

    // アトミックなint
    // デフォルト初期値は0
    private AtomicInteger counter = new AtomicInteger();
    // 初期値を設定可能
    //private AtomicInteger counter = new AtomicInteger(1);

    public int get() {
        // 現在の値を返す
        return counter.get();
    }

    public void set(int newValue) {
        // 値をセットし直す
        counter.set(newValue);
    }

    public int getAndSet(int newValue) {
        // 現在の値を取得してから更新
        return counter.getAndSet(newValue);
    }

    public int addAndGet(int x) {
        // 加算して返す
        return counter.addAndGet(x);
    }

    public int getAndAdd(int x) {
        // 現在の値を返した後加算
        return counter.getAndAdd(x);
    }

    public int incrementAndGet() {
        // インクリメントして返す
        return counter.incrementAndGet();
    }

    public int getAndIncrement() {
        // 現在の値を返した後インクリメント
        return counter.getAndIncrement();
    }

    public int decrementAndGet() {
        // デクリメントして返す
        return counter.decrementAndGet();
    }

    public int getAndDecrement() {
        // 現在の値を返した後デクリメント
        return counter.getAndDecrement();
    }




}
