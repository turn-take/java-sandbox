package interpreter;

public class Sample {
    public static void main(String[] args) {
        HTMLHeader htmlHeader = new HTMLHeader("Sample");

        HTMLBody htmlBody = new HTMLBody();

        HTMLTag htmlTag1 = new HTMLTag("p", "this is sample");
        HTMLTag htmlTag2 = new HTMLTag("p", "Hallo!");

        htmlBody.addTag(htmlTag1);
        htmlBody.addTag(htmlTag2);

        HTMLBuilder htmlBuilder = new HTMLBuilder(htmlHeader,htmlBody);

        htmlBuilder.build();
    }
}
