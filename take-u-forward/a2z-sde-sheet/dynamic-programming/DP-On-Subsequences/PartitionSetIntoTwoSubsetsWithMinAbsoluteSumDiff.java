/*
 * Blog: https://takeuforward.org/data-structure/partition-set-into-2-subsets-with-min-absolute-sum-diff-dp-16/
 * There are variations of this problem. In all similar questions done so far it was guaranteed, 
 * that 1 <= nums[i] but we have to address for additional case when it starts from 0. If it also has negative numbers,
 * like in the leetcode 2035, then we have to figure out another way to create the memoization table. 
 * Leetcode 2035 -> Need to see how it will work. 
 */
public class PartitionSetIntoTwoSubsetsWithMinAbsoluteSumDiff {
    // Heavily relying on target subset sum problem. 
    // DP[n][target + 1]
    // f(idx, target) | DP[idx][target] -> Signifies whether the given target is possible by summation of 
    // subsequences in the range[0..idx]. 
    // Last row of the DP Array basically tells what all targets can be formed from subsequences of 
    // arr[0 to n - 1] (Entire Array basically) with the sums in the range 0 to target. 
    // This question is asking us to divide the array into two equal length subsets such that 
    // s1: sum of all elements in subset1 and s2: sum of all elements in subset2, | s1 - s2 | is minimum of 
    // all. 
    // We can utilize the dp[idx][target+1] array for this. The last row tells us how many sums are possible
    // in the target range of [0...target]. 
    // For this question, the target will be in the range [0.....SumAll(Elements)]
    // We can figure out S1 sum using the dp array and subtract it from sumAll(Elements) to figure out S2.
    // For each S1, we can then see if the | S1- S2| is minimum. 

    public static int minSubsetSumDifference(int []arr, int n) {
        int totalSum = 0;
        for (int v: arr) totalSum += v;
        int min = tabulation(n, arr, totalSum);

        return min;
    }

     // O(NxTarget), O(NxTarget)
    private static int tabulation(int n, int[] arr, int sum) {
        boolean[][] dp = new boolean[n][sum+1];
        
        // Base Cases
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= sum; target++) {
                boolean pick = false;
                if (arr[i] <= target)
                    pick = dp[i - 1][target - arr[i]];
                boolean notPick = dp[i - 1][target];
                
                dp[i][target] = pick || notPick;
            }
        }
        
        int omin = Integer.MAX_VALUE;
        for (int i=0;i<=sum;i++) {
            if (dp[n-1][i] == true) {
                int s2 = sum - i;
                int abs = Math.abs(i - s2);
                omin = Math.min(abs, omin);
            }
        }

        return omin;
    }
}
