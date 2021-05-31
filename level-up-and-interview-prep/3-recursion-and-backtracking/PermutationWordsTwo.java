import java.io.*;
import java.util.*;

public class PermutationWordsTwo {
    // character chooses
    // to eliminate duplicates, we will make calls after last ocurrence of the
    // current char
    public static void generateWords(int cc, String str, Character[] spots, HashMap<Character, Integer> lastOccurence) {

        if(cc == str.length()) {
            for(char c: spots) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(cc);
        int lo = lastOccurence.get(ch);

        for(int i=lo+1;i<spots.length;i++) {
            if(spots[i] == null) {
                spots[i] = ch;
                lastOccurence.put(ch, i);
                generateWords(cc+1, str, spots, lastOccurence);
                lastOccurence.put(ch, lo);
                spots[i] = null;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        for(char ch: str.toCharArray()) {
            lastOccurrence.put(ch, -1);
        }
        Character[] boxes = new Character[str.length()];
        generateWords(0, str, boxes, lastOccurrence);
    }

}