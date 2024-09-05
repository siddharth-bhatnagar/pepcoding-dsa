/**
 * Blog: https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/
 * Leetcode 1143
 * 
 * f(idx1, idx2) -> returns length of longest common subsequence between 0...idx1 (string1) & 0...idx2 (string2)
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // return f(n - 1, m - 1, text1, text2);
        // int[][] dp = new int[n+1][m+1];
        // for (int i = 0; i <=n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // return memoized(n, m, text1, text2, dp);

        // return tabulation(text1, text2);
        return spaceOp(text1, text2);
    }

    // O(2^(mxn)), O(m + n)
    private int f (int i, int j, String s1, String s2) {
        if (i < 0 || j < 0) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            return (1 + f(i - 1, j - 1, s1, s2));
        } else {
            return (0 + Math.max(f (i - 1, j, s1, s2), f (i, j - 1, s1, s2)));
        }
    }

    // O(mxn), O(mxn + (m+n))
    // Right shifting the base case since we cannot store negative index in array.
    private int memoized(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) {
            return dp[0][0] = 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            return dp[i][j] = 1 + memoized(i-1, j-1, s1, s2, dp);
        } else {
            return dp[i][j] = 0 + Math.max(memoized(i-1, j, s1, s2, dp), memoized(i, j-1, s1, s2, dp));
        }
    }

    // O(mxn), O(mxn)
    private int tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base Case: Not needed to actually write this because by default everything is 0 in dp array.
        for (int j = 0; j <= m; j++) dp[0][j] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    // O(mxn), O(m)
    private int spaceOp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m + 1];

        // Base Case: Not needed to actually write this because by default everything is 0 in dp array.
        // for (int j = 0; j <= m; j++) prev[j] = 0;
        // for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                } else {
                    curr[j] = 0 + Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}


