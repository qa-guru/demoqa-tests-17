package demoqa.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(randomInt(10, 100)); // 66
        System.out.println(randomString(10)); // XA1qWIKlle
        System.out.println(randomEmail()); // qtENuczVAS@qa.guru

        String[] names = {"a", "b", "c", "d", "e"};
        System.out.println(randomItem(names)); // d
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomEmail() {
        return randomString(10) + "@qa.guru";
    }

    public static String randomItem(String[] values) { // todo some comment
        int index = randomInt(0, values.length - 1);
        return values[index];
    }

}
