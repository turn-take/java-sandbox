package systemProp;

public class Main {
    public static void main(String[] args) {
        System.getProperties().entrySet().stream()
                .forEach(e -> {
                    System.out.println("Key : " + e.getKey() + " value : " + e.getValue());
                });
    }
}
