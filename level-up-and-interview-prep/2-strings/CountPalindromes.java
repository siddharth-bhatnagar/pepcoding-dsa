//  Leetcode 647
// O(N^3)

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                count += isPallindrome(s, i, j) ? 1 : 0;
            }
        }

        return count;
    }

    private boolean isPallindrome(String s, int si, int ei) {
        while (si <= ei) {
            char ch1 = s.charAt(si);
            char ch2 = s.charAt(ei);

            if (ch1 != ch2)
                return false;

            si++;
            ei--;
        }

        return true;
    }
}

// DP - O(N^2) time, O(N^2) space
class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1)
            return 1;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; i < n && j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                }

                if (dp[i][j])
                    count++;
            }
        }

        return count;
    }
}