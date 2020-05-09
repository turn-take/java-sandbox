package java_gold.ch5;

public class CloseableClass implements AutoCloseable{
    @Override
    // closeメソッドのthrowsは省略可
    public void close() /** throws Exception**/{
    }
}
