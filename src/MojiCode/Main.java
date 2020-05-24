package MojiCode;

public class Main {
    public static void main(String[] args) {

        char ch = 'あ';

        int i = ch;
        String binaryI = Integer.toBinaryString(i);
        String hexI = Integer.toHexString(i);

        System.out.println(i);
        System.out.println(binaryI);
        System.out.println(hexI);
    }


}
