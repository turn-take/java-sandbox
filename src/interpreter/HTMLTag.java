package interpreter;

public class HTMLTag implements HTMLElement{

    private final String tagName;
    private final String text;

    public HTMLTag(String tagName, String text) {
        this.tagName = tagName;
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "<" + tagName + ">"
                + text
                + "</" + tagName + ">";
    }
}
