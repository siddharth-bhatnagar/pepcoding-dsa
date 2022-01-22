// Leetcode 5
// O(N^2) time, O(N^2) space

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return s;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int len = 0;
        int l = -1, r = -1;

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; i < n && j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true)
                        dp[i][j] = true;
                }

                if (dp[i][j] == true && j - i + 1 > len) {
                    len = j - i + 1;
                    l = i;
                    r = j;
                }
            }
        }

        return s.substring(l, r + 1);
    }
}

// Another approach: Expand around center - O(N^2) time, O(1) space
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expandAroundCenter(s, i, i);
            int l2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(l1, l2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R - L - 1;
    }
}