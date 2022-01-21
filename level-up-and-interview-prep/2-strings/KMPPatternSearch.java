// Leetcode 28
// O(M + N)
// Knuth Morris Pratt Using LPS Array

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0 || needle.length() > haystack.length())
            return -1;

        String str = needle + "$" + haystack;
        int n = str.length(), len = 0, i = 1;
        int[] LPS = new int[n];
        LPS[0] = 0;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                LPS[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = LPS[len - 1];
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }

        n = needle.length();
        int idx = -1;
        for (i = 0; i < LPS.length; i++) {
            int val = LPS[i];
            if (val == n) {
                idx = i - n + 1 - (n + 1);
                break;
            }
        }

        return idx;
    }
}