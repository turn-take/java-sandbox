package java_gold.ch11;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        String[] fruits = {"Orange", "Apple", "Strawberry"};
        // Arraysのsortメソッドには第二引数にComparatorをとるものがある。
        Arrays.sort(fruits, (s1,s2) -> LengthChecker.check(s1, s2));
        Arrays.sort(fruits, LengthChecker::check); // メソッド参照
    }
}

class LengthChecker {
    public static int check(String s1, String s2) {
        return s2.length() - s1.length();
    }
}
