package java_gold.ch8;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Walk {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("C:\\a"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                String dirName = dir.toString();
                System.out.println("preVisitDir : " + dirName);
                if(dirName.equals("C:\\a\\bsiv")) {
                    System.out.println("skipDir : " + dirName);
                    return FileVisitResult.SKIP_SIBLINGS;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String fileName = file.toString();
                System.out.println("visitFile : "  + fileName);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                String fileName = file.toString();
                System.out.println("visitFileFailed : " + fileName);
                exc.printStackTrace();
                return FileVisitResult.TERMINATE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                String dirName = dir.toString();
                System.out.println("postVisitDir : " + dirName);
//                if(dirName.equals("C:\\a\\bsiv")) {
//                    System.out.println("skipDir : " + dirName);
//                    return FileVisitResult.SKIP_SIBLINGS;
//                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
