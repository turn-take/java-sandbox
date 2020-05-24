package java_gold.ch11;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileWalkSample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("Sample");
        Files.walkFileTree(path, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                System.out.println("preVisit : " + dir);

//                if(dir.getFileName().toString().equals("SampleChildSiv")) {
//                    System.out.println("skip : " + dir);
//                    return FileVisitResult.SKIP_SUBTREE;
//                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                exc.printStackTrace();
                return FileVisitResult.TERMINATE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("postVisit : " + dir);

                if(dir.getFileName().toString().equals("SampleChildSiv")) {
                    System.out.println("skip : " + dir);
                    return FileVisitResult.SKIP_SIBLINGS;
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }
}
