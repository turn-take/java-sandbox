package interpreter;

import java.util.Arrays;

public class HTMLBuilder {

    private final HTMLHeader htmlHeader;
    private final HTMLBody htmlBody;


    public HTMLBuilder(HTMLHeader htmlHeader, HTMLBody htmlBody) {
        this.htmlHeader = htmlHeader;
        this.htmlBody = htmlBody;
    }

    public void build() {
        System.out.println("<html>");
        htmlHeader.print();
        htmlBody.print();
        System.out.println("</html>");
    }

}
