import integerlist.IntegerList;
import integerlist.IntegerListImpl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Random random = new Random();
        IntegerList array = new IntegerListImpl();
        for (int i=0;i<100_000;i++) {
            array.add(random.nextInt(999_999));
        }
        boolean contains = array.contains(57_945);
        System.out.println(contains);
    }
}