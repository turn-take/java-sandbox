package effectiveInterface;

import effectiveInterface.inerfaces.Sample;
import effectiveInterface.inerfaces.Sample2;

public class Main implements Sample {

    public static void main(String[] args) {
        Main main = new Main();
        main.template(1,2);

        Sample2 s = (x, y) -> x * y;
        // 関数IFのデフォルトメソッドを実行
        s.template(3,4);
    }

    @Override
    public int doSomething1(int x, int y) {
        return x + y;
    }

    @Override
    public void doSomething2(int i) {
        System.out.println(i);
    }
}
