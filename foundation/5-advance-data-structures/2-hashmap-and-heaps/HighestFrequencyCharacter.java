import java.io.*;
import java.util.*;

public class HighestFrequencyCharacter {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = new String(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        int mf = 0;
        char mfch = ' ';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (map.containsKey(ch) == true) {
                int prevCount = map.get(ch);
                int currCount = prevCount + 1;
                map.put(ch, currCount);
            } else {
                map.put(ch, 1);
            }

            if (mf < map.get(ch)) {
                mf = map.get(ch);
                mfch = ch;
            }
        }
        System.out.println(mfch);
    }

}