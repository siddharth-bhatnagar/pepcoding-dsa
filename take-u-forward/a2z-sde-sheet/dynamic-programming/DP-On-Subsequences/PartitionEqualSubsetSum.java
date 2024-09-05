/*
 * Blog: https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/
 * 
 */
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] arr, int n) {
		int totalSum = 0;
		for (int v: arr) {
			totalSum += v;
		}

		if (totalSum % 2 == 1) return false;
		else {
			// int[][] dp = new int[n][(totalSum / 2) + 1];
			// for (int i=0;i<n;i++) {
			// 	Arrays.fill(dp[i], -1);
			// }
			// return memoized(arr, dp, totalSum / 2, n - 1);
			// return tabulation(arr, n, totalSum/2);
			return spaceOp(arr, n, totalSum/2);
		}	
	}

    // O(Exponential), O(N)
	private static boolean f (int[] arr, int target, int idx) {
		if (target == 0) return true;
		if (idx == 0) return arr[0] == target;

		boolean notTaken = f(arr, target, idx-1);
		boolean taken = false;
		if (arr[idx] <= target) {
			taken = f(arr, target - arr[idx], idx-1);
		}

		return taken || notTaken;
	}

    // O(N*target), O(N + N*target)
	private static boolean memoized(int[] arr, int[][] dp, int target, int idx) {
		if (target == 0) return true;
		if (idx == 0) return arr[0] == target;

		if (dp[idx][target] != -1) return dp[idx][target] == 1 ? true : false;

		boolean notTaken = memoized(arr, dp, target, idx-1);
		boolean taken = false;
		if (arr[idx] <= target) {
			taken = memoized(arr, dp, target - arr[idx], idx-1);
		}

		dp[idx][target] = taken || notTaken ? 1 : 0;
		return taken || notTaken;
	}

    // O(N*target), O(N*target)
	private static boolean tabulation(int[] arr, int n, int target) {
		boolean[][] dp = new boolean[n][target + 1];

		// Base Cases
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		if (arr[0] <= target) {
			dp[0][arr[0]] = true;
		}

		for (int i = 1; i < n; i++) {
			for (int sum = 1; sum <= target; sum++) {
				boolean notTaken = dp[i - 1][sum];
				boolean taken = false;
				
				if (arr[i] <= sum) {
					taken = dp[i-1][sum - arr[i]];
				}

				dp[i][sum] = taken || notTaken;
			}
		}

		return dp[n-1][target];
	}

    // O(N*target), O(target)
	private static boolean spaceOp(int[] arr, int n, int target) {
		boolean[] dp = new boolean[target + 1];

		// Base Cases
		dp[0] = true;
		

		if (arr[0] <= target) {
			dp[arr[0]] = true;
		}

		for (int i = 1; i < n; i++) {
			boolean[] c = new boolean[target+1];
			for (int sum = 1; sum <= target; sum++) {
				boolean notTaken = dp[sum];
				boolean taken = false;
				
				if (arr[i] <= sum) {
					taken = dp[sum - arr[i]];
				}

				c[sum] = taken || notTaken;
			}
			dp = c;
		}

		return dp[target];
	}
}
