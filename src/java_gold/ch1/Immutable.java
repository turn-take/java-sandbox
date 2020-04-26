package java_gold.ch1;

public final class Immutable {

    private final int x;
    private final int[] array = {1,2,3};

    public Immutable(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public Immutable add(int y) {
        // 新しいインスタンスを返すことで自信の状態に変更がない
        return new Immutable(x + y);
    }
}
