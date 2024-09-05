/*
 * https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/
 * 
 */
public class PrintingLongestCommonSubsequence {

    // O(nxm + (n+m)), O(nxm + len)
    private void lcs(String s1, String s2) {

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

        int len = dp[n][m];
        int i = n;
        int j = m;
        
        int index = len-1;
        StringBuilder str = new StringBuilder();
        for(int k=1; k<=len;k++){
            str.append("$"); // dummy string
        }
     
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                str.setCharAt(index, s1.charAt(i-1)); 
                index--;
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else j--;
        }
        System.out.println(str);
    }
}
