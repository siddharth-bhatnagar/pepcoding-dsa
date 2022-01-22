// Leetcode 14
// Longest Common Prefix
// O(M*N) where M is the number of strings, N is length of Longest String

class Solution {
    public String longestCommonPrefix(String[] arr) {
        if(arr.length == 0) return "";
        int n = arr.length;
        String str = arr[0];
        int len = str.length();
        for(int i=1;i<n;i++) {
            String s = arr[i];
            int m = s.length();
            int j = 0;
            while(j < m && j < len && str.charAt(j) == s.charAt(j)) j++;
            len = Math.min(len, j);
        }
        
        return str.substring(0, len);
    }
}