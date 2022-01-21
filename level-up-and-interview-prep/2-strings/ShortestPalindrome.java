// Leetcode 214
// Optimal using LPS O(N)

class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() == 0) return s;
        String str = s + "#" + new StringBuilder(s).reverse().toString();
        int lps = LPS(str);
        
        String result = new StringBuilder(s.substring(lps)).reverse().toString() + s;
        return result;
    }
    
    private int LPS(String str) {
        int n = str.length(), len = 0, i = 1;
        int[] lps = new int[n];
        
        while(i < n) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len > 0) {
                    len = lps[len-1];
                }
                else {
                    i++;
                }
            }
        }
        
        return lps[n-1];
    }
}

// Brute Force - O(N^2);

class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() == 0) return s;
        int i;
        for(i=s.length()-1;i>=0;i--) {
            if(isPalindrome(s, 0, i)) {
                break;    
            }
        }
        
        String ans = new StringBuilder(s.substring(i+1)).reverse().toString() + s;
        return ans;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            
            i++;
            j--;
        }
        
        return true;
    }
}