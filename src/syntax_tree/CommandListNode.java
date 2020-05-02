package syntax_tree;

import java.util.ArrayList;
import java.util.List;

public class CommandListNode extends Node {

    private List<Node> commandNodeList = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        // 'end'がくるまで解析を続ける
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                commandNodeList.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return commandNodeList.toString();
    }
}
