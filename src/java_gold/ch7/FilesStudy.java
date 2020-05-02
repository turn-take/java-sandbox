package java_gold.ch7;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class FilesStudy {
    public static void main(String[] args) throws IOException {

//        // Filesクラスのcopyメソッドでファイルのコピー
//        Path source = Paths.get("source");
//        Path dest = Paths.get("dest");
//        // デフォルトではコピー先ファイルが既に存在する場合は、例外が発生するので
//        // StandardCopyOption.REPLACE_EXISTINGオプションを付与する
//        Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
//        // ファイル属性をコピー
//        Files.copy(source, dest, StandardCopyOption.COPY_ATTRIBUTES);
//        // シンボリックリンクを辿らないコピー
//        // リンクの場合にはリンク自体のみがコピー
//        Files.copy(source, dest, LinkOption.NOFOLLOW_LINKS);
//
//        // FilesのlinesメソッドでString型のStreamを取得（行ごと）
//        // ファイルのクローズが必要なのでtry-with-resource
//        try(Stream<String> stream = Files.lines(Paths.get("\"C:\\a\\b\\c\\c.txt\""))) {
//            stream.forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Filesのlistメソッドにディレクトリのパスを渡すことで、そのディレクトリ内のエントリをStream<Path>として取得する。
        // ファイルのパスを渡すと例外発生
        // ディレクトリを再帰的に辿らない。指定したディレクトリ内だけ
        try(Stream<Path> pathStream = Files.list(Paths.get("C:\\a"))) {
            pathStream.forEach(System.out::println);
        }

        // walkメソッドで指定したディレクトリをトラバースして辿る
        try(Stream<Path> pathStream = Files.walk(Paths.get("C:\\a"))) {
            pathStream.forEach(System.out::println);
        }
    }
}
