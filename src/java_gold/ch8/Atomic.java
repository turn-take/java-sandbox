package java_gold.ch8;

import java.util.concurrent.atomic.AtomicReference;

public class Atomic {
    public static void main(String[] args) {
        AtomicReference<Sample> atomicReference = new AtomicReference(new Sample(5, "hoge"));

        atomicReference.getAndUpdate(v -> {
            v.setA(1);
            v.setSomeString("fuga");
            return v;
        });

        atomicReference.accumulateAndGet(new Sample(6, "piyo"), (v1, v2) -> {
            v1.setA(v1.getA() + v2.getA());
            return v2;
        });

    }
}

class Sample {
    private int a;
    private String someString;

    public Sample(int a, String someString) {
        this.a = a;
        this.someString = someString;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public int getA() {
        return a;
    }

    public String getSomeString() {
        return someString;
    }
}

