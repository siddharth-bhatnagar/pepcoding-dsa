import java.io.*;
import java.util.*;

public class WordsKLengthWordsOne {

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
        Character[] spots = new Character[k];
        wordPermutations(ustr, k, 0, 0, spots);
    }

    public static void wordPermutations(String ustr, int ts, int ssf, int ci, Character[] spots) {
        
        if(ci == ustr.length()) {
            if(ssf == ts) {
                for(char ch: spots) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }

        char ch = ustr.charAt(ci);
        // call for yes
        for(int i=0;i<spots.length;i++) {
            if(spots[i] == null) {
                spots[i] = ch;
                wordPermutations(ustr, ts, ssf+1,ci+1, spots);
                spots[i] = null;
            }
        }
        // call for no
        wordPermutations(ustr, ts, ssf,ci+1, spots);
    }

}