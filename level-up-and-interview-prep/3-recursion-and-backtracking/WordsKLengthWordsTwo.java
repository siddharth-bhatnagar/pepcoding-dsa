import java.io.*;
import java.util.*;

public class WordsKLengthWordsTwo {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        wordPermutations(ustr, 1, k, new HashSet<>(), "");
    }

    // cs = current spot
    public static void wordPermutations(String ustr,int cs, int ts, HashSet<Character> set, String asf) {

        if(cs > ts) {
            System.out.println(asf);
            return;
        }

        for(int i=0;i<ustr.length();i++) {
            char ch = ustr.charAt(i);
            if(!set.contains(ch)) {
                set.add(ch);
                wordPermutations(ustr, cs+1, ts, set, asf+ch);
                set.remove(ch);
            }
        }
    }

}