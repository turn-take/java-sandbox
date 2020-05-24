package java_gold.ch11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadSample {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("cert.txt")) {
            int ch;
            while (fileReader.ready()) {
                fileReader.skip(3);
                ch = fileReader.read();
                System.out.print(" " + ch);
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
