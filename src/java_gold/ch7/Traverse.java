package java_gold.ch7;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Traverse {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\a\\b\\c");

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
