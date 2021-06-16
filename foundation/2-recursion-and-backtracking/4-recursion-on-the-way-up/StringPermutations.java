import java.util.*;

public class StringPermutations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printPermutations(str, "");
        permutations2(0, str, new Character[str.length()]); 
        scn.close();
    }

    // in dictionary order
    public static void printPermutations(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < ques.length(); i++) {
            char fChar = ques.charAt(i);
            String remstring = ques.substring(0, i) + ques.substring(i + 1);
            printPermutations(remstring, ans + fChar);
        }
    }


    // Not in dictionary order
    public static void permutations2(int cc, String str, Character[] spots) {
        if(cc == str.length()) {
            for(char c: spots) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        
        char ch = str.charAt(cc);
        for(int i=0;i<spots.length;i++) {
            if(spots[i] == null) {
                spots[i] = ch;
                permutations2(cc + 1, str, spots);
                spots[i] = null;
            }
        }
    }

}

