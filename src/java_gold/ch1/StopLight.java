package java_gold.ch1;

// トップレベルのenumはpublic or デフォルト
public enum StopLight {
    GREEN, YELLOW, RED;
}

class sample {
    // 名前から列挙型インスタンスを取得できる
    StopLight green = StopLight.valueOf("GREEN");
    // 存在しない名前は例外発生
    StopLight yellow = StopLight.valueOf("yellow");

    StopLight[] array = StopLight.values();

    String g = StopLight.GREEN.name();
}
