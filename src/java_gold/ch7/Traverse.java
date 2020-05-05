package java_gold.ch7;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Traverse {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\a\\b\\c");

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

            // ファイルをたどった時
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }

            // ファイルをたどれなかった時
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                exc.printStackTrace();
                return FileVisitResult.TERMINATE;
            }

            // ディレクトリをたどった後
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println(dir);
                return FileVisitResult.CONTINUE;
            }

            // ディレクトリをたどる前
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println(dir.getFileName());
                return FileVisitResult.SKIP_SUBTREE;
            }
        });


    }
}
