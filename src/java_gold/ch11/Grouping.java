package java_gold.ch11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<Musician> musicianList = Arrays.asList(
                new Musician("Jimi Hendrix", Musician.Category.ROCK),
                new Musician("Eric Dolphy", Musician.Category.JAZZ),
                new Musician("J.S Bach", Musician.Category.CLASSICAL),
                new Musician("Charles Mingus", Musician.Category.JAZZ)
        );

        Map<Musician.Category, List<String>> map = musicianList.stream()
                .collect(Collectors.groupingBy(
                        Musician::getCategory, // グルーピングするキーを取得
                        Collectors.mapping(Musician::getName, Collectors.toList()) // グルーピングされた値をリダクションするCollectorオブジェクト。
                ));
        System.out.println(map);
    }
}

class Musician {

    public enum Category {
        ROCK, JAZZ, CLASSICAL
    }

    private String name;
    private Category category;

    public Musician(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}
