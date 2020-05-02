package syntax_tree;

public class CommandNode extends Node{

    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if(context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
        } else {
            node = new PrimitiveCommandNode();
        }
        node.parse(context);
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
