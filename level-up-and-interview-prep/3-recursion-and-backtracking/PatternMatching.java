import java.util.*;

public class PatternMatching {

    public static void solution(String str, String pattern, HashMap<Character, String> map, String op) {

        if(pattern.length() == 0) {
            if(str.length() == 0) {
                HashSet<Character> set = new HashSet<>();
                for(int i=0;i<op.length();i++) {
                    char c = op.charAt(i);
                    if(set.contains(c) == false) {
                        set.add(c);
                        System.out.print(c + " -> " + map.get(c) + ", ");
                    }
                }
                System.out.println(".");
            }

            return;
        }


        char ch = pattern.charAt(0);
        String rop = pattern.substring(1);

        if (map.containsKey(ch)) {
            String val = map.get(ch);
            if (str.length() >= val.length()) {
                String prefixes = str.substring(0, val.length());
                String ros = str.substring(val.length());
                if (prefixes.equals(val)) {
                    solution(ros, rop, map, op);
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String prefixes = str.substring(0, i + 1);
                String ros = str.substring(i + 1);
                map.put(ch, prefixes);
                solution(ros, rop, map, op);
                map.remove(ch);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap<Character, String> map = new HashMap<>();
        solution(str, pattern, map, pattern);
        scn.close();
    }
}