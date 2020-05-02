package syntax_tree;

import java.util.StringTokenizer;

public class Context {
    private StringTokenizer tokenizer;
    private String currentToken;

    public Context(String text) {
        tokenizer = new StringTokenizer(text);
        nextToken();
    }

    /**
     * 次のトークンを取得する。
     * @return String 次のトークン
     */
    public String nextToken() {
        if(tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    /**
     * 現在のトークンを取得する。
     * @return String 現在のトークン
     */
    public String currentToken() {
        return currentToken;
    }

    /**
     * トークンをスキップする。
     * @param token スキップするトークン
     * @throws ParseException 引数で渡されたトークンと現在のトークンが一致しない場合
     */
    public void skipToken(String token) throws ParseException {
        if(!token.equals(currentToken)) {
            throw new ParseException("warning: " + token + "is expected, but " + currentToken + " is found.");
        }
        nextToken();
    }

    /**
     * 現在のトークンを数値として取得するが、トークンは次へは進まない。
     * @return int 現在のトークンの数値
     * @throws ParseException 現在のトークンが数値以外の場合
     */
    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning: " + e);
        }
        return number;
    }


}
