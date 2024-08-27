/**
 * Blog: https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/
 */
public class SubsetSumEqualTarget {
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // return f(N-1, arr, sum);
        // Boolean[][] dp = new Boolean[N][sum+1];
        // return memoized(N-1, arr, sum, dp);
        // return tabulation(N, arr, sum);
        return spaceOp(N, arr, sum);
    }
    
    // f(idx, target) -> returns true/false if there is any subsequence from 0 to idx whose sum equal to target
    // check all possible ways
    // O(Exponential), O(NxTarget)
    private static boolean f(int idx, int[] arr, int sum) {
        // Base case
        if (sum == 0) return true;
        if (idx == 0) return arr[0] == sum;
        
        boolean pick = false;
        if (arr[idx] <= sum)
            pick = f(idx - 1, arr, sum - arr[idx]);
        boolean notPick = f(idx - 1, arr, sum);
        
        return pick || notPick;
    }
    
    // O(NxTarget), O(N + NxTarget)
    private static boolean memoized(int idx, int[] arr, int sum, Boolean[][] dp) {
        // Base case
        if (sum == 0) return dp[idx][sum] = true;
        if (idx == 0) return arr[0] == sum;
        
        if (dp[idx][sum] != null) return dp[idx][sum];
        
        boolean pick = false;
        if (arr[idx] <= sum)
            pick = memoized(idx - 1, arr, sum - arr[idx], dp);
        boolean notPick = memoized(idx - 1, arr, sum, dp);
        
        return dp[idx][sum] = pick || notPick;
    }
    
    
    // O(NxTarget), O(NxTarget)
    private static boolean tabulation(int n, int[] arr, int sum) {
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
        
        return dp[n-1][sum];
    }
    
    // O(N X Target), O(Target)
    private static boolean spaceOp(int n, int[] arr, int sum) {
        boolean[] prev = new boolean[sum+1];
        
        // Base Cases
        prev[0] = true;
        if (arr[0] <= sum) {
            prev[arr[0]] = true;
        }
        
        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for (int target = 1; target <= sum; target++) {
                boolean pick = false;
                if (arr[i] <= target)
                    pick = prev[target - arr[i]];
                boolean notPick = prev[target];
                
                curr[target] = pick || notPick;
            }
            prev = curr;
        }
        
        return prev[sum];
    }
}
