package interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * HTMLのbody要素
 */
public class HTMLBody implements HTMLElement{

    // body要素内のタグ一覧
    private List<HTMLTag> htmlTagList = new ArrayList<>();

    /**
     * HTMLタグを追加する。
     * @param htmlTag HTMLタグ要素
     */
    public void addTag(HTMLTag htmlTag) {
        htmlTagList.add(htmlTag);
    }

    @Override
    public void print() {
        System.out.println("<body>");
        htmlTagList.forEach(HTMLTag::print);
        System.out.println("</body>");
    }
}
