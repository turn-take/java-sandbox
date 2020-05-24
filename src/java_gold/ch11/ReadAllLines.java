package java_gold.ch11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadAllLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("");
        // ファイル内の文字列一覧のリスト
        List<String> list = Files.readAllLines(path);
        // ファイル内の文字列一覧のストリーム
        Stream<String> line = Files.lines(path);

    }
}
