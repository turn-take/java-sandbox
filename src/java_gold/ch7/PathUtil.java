package java_gold.ch7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {
    public static void main(String[] args) throws IOException {
        // Pathsのgetメソッドは相対パスでも良い
        Path path = Paths.get("sample.txt");
        // Filesのlinesメソッドは内部でBufferedReaderを使用している。
        Files.lines(path).forEach(System.out::println);

        // File → Path
        File file = new File("sample.txt");
        Path path2 = file.toPath();
        Files.lines(path2).forEach(System.out::println);
    }
}
