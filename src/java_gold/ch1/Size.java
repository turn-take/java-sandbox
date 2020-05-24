package java_gold.ch1;

/**
 * オーバーロードされたコンストラクタを持つenum
 */
public enum Size {
    NA, S(1), M(5), L(10); // NAはint型デフォルトの0で初期化される

    private int value;

    private Size() {} // 引数を取らないコンストラクタ

    private Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // enumは不変であるべきなのでセッターは実装すべきでは内
    public void setValue(int value) {
        this.value = value;
    }
}