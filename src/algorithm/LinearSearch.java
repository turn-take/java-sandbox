package algorithm;

public class LinearSearch<T> {

    static private class Entry<T> {
        int key;
        T data;

        private Entry(int key, T data) {
            this.key = key;
            this.data = data;
        }
    }

    final static int MAX = 100;
    Entry[] table = new Entry[MAX];
    int n = 0;

    public void add(int key, T data) {
        if (n >= MAX) {
            throw new IllegalArgumentException();
        }
        table[n++] = new Entry(key,data);
    }

    public T search(int key) {
        int i = 0;
        while (i < n) {
            if (table[i].key == key) {
                return (T) table[i].data;
            }
        }
        return null;
    }
}
