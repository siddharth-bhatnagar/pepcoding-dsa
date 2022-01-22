// Leetcode 14
// Longest Common Prefix
// O(M*N) where M is the number of strings, N is length of Longest String

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (s.indexOf(lcp) != 0) {
                lcp = lcp.substring(0, lcp.length() - 1);
            }
        }

        return lcp;
    }
}