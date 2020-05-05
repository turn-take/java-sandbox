package java_gold.ch7;

import java.io.Console;

public class CLI {
    public static void main(String[] args) {
        Console console;
        String line;
        // IntelliJではSystem.console()はnullになります。
        if((console = System.console()) != null && (line = console.readLine()) != null) {
            System.out.println(line);
        }
    }
}
