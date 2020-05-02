package decoraator;

/**
 * 複数行からなる文字列を表示するための抽象クラス
 */
public abstract class Display {

    /**
     * 横の文字数取得
     * @return 横の文字数
     */
    public abstract int getColumns();

    /**
     * 行数取得
     * @return 行数
     */
    public abstract int getRows();

    /**
     * 引数で与えられた行数の文字列を取得する。
     * @param row
     * @return
     */
    public abstract String getRowText(int row);

    /**
     * 表示する。
     */
    public final void show() {
        // 行数分ループ
        for (int i = 1; i < getRows() + 1; i++) {
            System.out.println(getRowText(i));
        }
    }
}
