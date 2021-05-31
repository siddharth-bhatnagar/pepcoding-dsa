import java.util.*;

public class Cryptarithmetic {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        String s3 = scn.next();

        String unique = "";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (map.containsKey(ch) == false) {
                unique += ch;
                map.put(ch, -1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.containsKey(ch) == false) {
                unique += ch;
                map.put(ch, -1);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            char ch = s3.charAt(i);
            if (map.containsKey(ch) == false) {
                unique += ch;
                map.put(ch, -1);
            }
        }

        boolean[] numbers = new boolean[10];
        cryptarithmetic(unique, 0, map, numbers, s1, s2, s3);
        scn.close();
    }

    public static void cryptarithmetic(String unique, int ci, HashMap<Character, Integer> map, boolean[] numbers,
            String s1, String s2, String s3) {

        if (ci == unique.length()) {
            int num1 = getNum(s1, map);
            int num2 = getNum(s2, map);
            int num3 = getNum(s3, map);

            if (num1 + num2 == num3) {
                for (int i = 0; i < 26; i++) {
                    char c = (char) ('a' + i);
                    if (map.containsKey(c)) {
                        System.out.print(c + "-" + map.get(c) + " ");
                    }
                }
                System.out.println();
            }

            return;
        }

        char ch = unique.charAt(ci);
        for (int i = 0; i <= 9; i++) {
            if (numbers[i] == false) {
                numbers[i] = true;
                map.put(ch, i);
                cryptarithmetic(unique, ci + 1, map, numbers, s1, s2, s3);
                numbers[i] = false;
                map.put(ch, -1);
            }
        }
    }

    public static int getNum(String str, HashMap<Character, Integer> map) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(map.get(ch));
        }

        return Integer.parseInt(sb.toString());
    }
}
