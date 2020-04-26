package interpreter;

public class HTMLHeader implements HTMLElement{

    private final String title;

    public HTMLHeader(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "<head>\n"
                + "<title>" + title + "</title>\n"
                + "</head>";
    }
}
