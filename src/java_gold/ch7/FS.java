package java_gold.ch7;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FS {
    public static void main(String[] args) throws IOException {
        // システムデフォルトのファイルシステムクラスを取得
        FileSystem fileSystem = FileSystems.getDefault();

        // Pathの取得
        Path path = fileSystem.getPath("C:\\x\\y\\z");
        Path path2 = Paths.get("C:\\x\\y\\z");

        // File ⇒ Path
        File file = new File("C:\\x\\y\\z");
        Path path3 = file.toPath();

        System.out.printf("%s, %s, %s, %d",
                path.getRoot(), // ルート名取得 区切り文字(\)を含む
                path.getName(0), // インデックス指定したエントリの名前をルートを除いて取得
                path.getFileName(), // パスの最下層のエントリ名を取得
                path.getNameCount()); // パス内のルートを除いたエントリの数
        System.out.println();

        // パスから一部抽出
        System.out.println(path.subpath(1,2));

        Path path4 = Paths.get("C:\\a\\b\\c");
        Path path5 = Paths.get(".\\hoge");

        // resolveメソッド
        // 絶対パスは渡されたパスを返す
        System.out.println(path.resolve(path4));
        // 相対パスは結合されたパス
        System.out.println(path.resolve(path5));
        // 空白はそのパス自体
        System.out.println(path.resolve(""));

        // resolveSiblingメソッド
        // 絶対パスは渡されたパスそのもの
        System.out.println(path.resolveSibling(path4));
        // 相対パスは親ディレクトリからのパス
        System.out.println(path.resolveSibling(path5));
        // 空白は親ディレクトリ
        System.out.println(path.resolveSibling(""));
        // 呼び出し側が相対パスなら引数で渡したパスそのもの
        System.out.println(path5.resolveSibling(path4));

        // 冗長性を正規化
        Path path6 = Paths.get("C:\\a\\.\\..\\a\\b\\..\\b\\c\\.");
        System.out.println(path6.normalize());

        // 渡されたパスから相対パスを返す
        Path path7 = Paths.get("C:\\abc\\xyz");
        Path path8 = Paths.get("C:\\xyz\\abc");
        System.out.println(path7.relativize(path8));

        FileTime fileTime = (FileTime) Files.getAttribute(path, "creationTime");
        System.out.println(fileTime);

    }
}
