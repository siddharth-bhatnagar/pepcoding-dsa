import java.io.*;
import java.util.*;

public class WordsKSelectionTwo {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        HashSet<Character> set = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                ustr += ch;
                set.add(ch);
            }
        }

        selection(ustr, "", -1, k, 0);
    }

    public static void selection(String ustr, String asf, int ls, int k, int ssf) {

        if (ssf == k) {
            System.out.println(asf);
            return;
        }

        for (int i = ls + 1; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            selection(ustr, asf + ch, i, k, ssf + 1);
        }
    }
}
