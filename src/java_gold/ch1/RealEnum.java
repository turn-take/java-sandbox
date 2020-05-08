package java_gold.ch1;

/**
 * enum的なクラスの簡易実装
 */
public class RealEnum {

    public static final RealEnum CONST1 = new RealEnum(1);
    public static final RealEnum CONST2 = new RealEnum(2);
    public static final RealEnum CONST3 = new RealEnum(1);

    private final int value;

    public static final RealEnum[] values = {CONST1,CONST2,CONST3};

    private RealEnum(final int value) {
        this.value = value;
    }

    public static RealEnum[] values() {
        return values;
    }

}
