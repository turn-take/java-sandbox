package decoraator;

/**
 * 文字列を表示するクラス
 * このサンプルアプリケーション内では飾り枠に包まれる一番内側の中身となる。
 */
public class StringDisplay extends Display{

    private final String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.length();
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if(row == 1) {
            return string;
        } else {
            return null;
        }
    }
}
