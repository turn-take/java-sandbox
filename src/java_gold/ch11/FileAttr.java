package java_gold.ch11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.stream.Stream;

public class FileAttr {
    public static void main(String[] args) {
        Path dir = Paths.get(System.getProperty("user.dir"));
        try (Stream<Path> pathStream = Files.walk(dir)) {
            pathStream.forEach(path -> {
                try {
                    FileTime time = Files
                            // FilesのreadAttributesメソッドでファイル属性を取得できる。
                            // 第一引数は対象のパスオブジェクト、第二引数はファイル属性のクラス
                            .readAttributes(path, BasicFileAttributes.class)
                            .lastModifiedTime();
                    System.out.println(path + ":" + time);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
