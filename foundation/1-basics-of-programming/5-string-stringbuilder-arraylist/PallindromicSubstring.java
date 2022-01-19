import java.io.*;
import java.util.*;

public class PallindromicSubstring {

    public static void solution(String str) {
        int len = str.length();
        for (int k = 0; k < len; k++) {
            for (int i = k + 1; i <= len; i++) {
                String subset = str.substring(k, i);
                char[] arr = subset.toCharArray();
                String rev = "";
                for (int j = arr.length - 1; j >= 0; j--) {
                    rev += arr[j];
                }
                if (rev.equals(subset)) {
                    System.out.println(subset);
                }
            }
        }
    }
    // This can also be achieved using StringBuilder class and using it's reverse() method.    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }
}

// Leetcode 647
// O(n3) solution

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                count += isPallindrome(s, i, j) ? 1 : 0;
            }
        }
        
        return count;
    }
    
    private boolean isPallindrome(String s, int si, int ei) {
        while(si <= ei) {
            char ch1 = s.charAt(si);
            char ch2 = s.charAt(ei);
            
            if(ch1 != ch2) return false;
            
            si++;
            ei--;
        }
        
        return true;
    }
}
