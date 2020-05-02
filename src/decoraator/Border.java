package decoraator;

/**
 * 飾り枠を表す抽象クラス
 */
public abstract class Border extends Display{

    // 飾り枠が包む中身
    protected final Display display;

    protected Border(Display display) {
        this.display = display;
    }
}
