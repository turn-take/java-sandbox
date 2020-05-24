package java_gold.ch11;

public class MethodRef {
    public static void main(String[] args) {
        Flyable f1 = s -> new Airplane(s);
        // コンストラクタ参照
        Flyable f2 = Airplane::new;
    }
}

interface Flyable {
    Airplane getAirplane(String name);
}

class Airplane {
    private String name;

    public Airplane(String name) {
        this.name = name;
    }
}
