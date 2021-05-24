import java.util.*;

public class WordsKSelectionTwo {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int k = scn.nextInt();

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        combination(ustr, 0, k, -1, "");
        scn.close();
    }

    public static void combination(String ustr, int ssf, int ts, int lch, String asf) {
        if (ssf == ts) {
            System.out.println(asf);
            return;
        }
        for (int i = lch + 1; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            combination(ustr, ssf + 1, ts, i, asf + ch);
        }

    }

}