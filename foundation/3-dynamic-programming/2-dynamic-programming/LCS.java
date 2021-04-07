// Longest Common Subsequence

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text1.length() - 1, text2, text2.length() - 1, new int[text1.length()][text2.length()]);
    }

    public int lcs(String t1, int i, String t2, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int ans = 0;
        if (t1.charAt(i) == t2.charAt(j)) {
            int temp = lcs(t1, i - 1, t2, j - 1, dp);
            ans = temp + 1;
        } else {
            int temp1 = lcs(t1, i - 1, t2, j, dp);
            int temp2 = lcs(t1, i, t2, j - 1, dp);

            ans = Math.max(temp1, temp2);
        }

        dp[i][j] = ans;
        return ans;
    }

}