import java.util.*;

public class MaxScore {

    // Each word has two choices, it will join or not join
    // If it joins, we have to check if it can contribute to the ans or not
    public static int solution(String[] words, int[] farr, int[] score, int idx) {

        if(idx == words.length) {
            return 0;
        }

        // Not included ans
        int nans = 0 + solution(words, farr, score, idx+1);

        String word = words[idx];
        // check if this word can contribute to ans or not
        int yanscontri = 0;
        boolean flag = true;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);

            if(farr[ch - 'a'] == 0) {
                flag = false;
            }

            farr[ch - 'a'] -= 1;
            yanscontri += score[ch - 'a'];
        }

        int yans = 0;
        if(flag) {
            yans = yanscontri + solution(words, farr, score, idx+1);
        }
        
        // undoing the change
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }

        return Math.max(yans, nans);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // TOTAL WORDS  
        int nofWords = scn.nextInt();
        
        // Words array
        String[] words = new String[nofWords];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }

        // total number of letters
        int nofLetters = scn.nextInt();
        
        // letters array
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }

        // score array
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        scn.close();


        // edge case
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            return;
        }

        // frequency array: tells how many times we can use an alphabet
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        
        System.out.println(solution(words, farr, score, 0));

    }
}