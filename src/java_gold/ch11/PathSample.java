package java_gold.ch11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathSample {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("/movies/sample/ex.mp4");
        System.out.println(p.getNameCount() + ":" + p.getName(1) + ":" + p.getFileName());
        System.out.println(p.getRoot()); // 「\」が表示される。

        Path src = Paths.get("DATA\\JAN\\log.txt");
        // Filesのコピーメソッドの第二引数にはコピー先のパスを指定する。（この場合はDATAというファイルができる。）
        // "DATA"というファイル（ディレクトリ）は存在しているので例外発生
        Path dest = Paths.get("DATA");
        Files.copy(src, dest);
    }
}
