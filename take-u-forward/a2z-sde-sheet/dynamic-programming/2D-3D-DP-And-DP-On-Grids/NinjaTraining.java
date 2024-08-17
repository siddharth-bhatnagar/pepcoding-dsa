/*
 * Greedy wont work as we may miss out on the answer. 
 * Refer tuf blog: https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/
 * 
 * We have to check for all possible ways by applying the constraints.
 * constraint is the activity which we are choosing on a given day should not be
 * the same as the previous day.
 * 
 * We can use an extra parameter in the recursive function: last -> representing the index of activity done on previous day
 * day -> representing the index of the day on the main array.
 * 
 * basically f(day, last) -> we are solving the problem for the given 'day' when previous day activity was 'last'
 */
public class NinjaTraining {
    // Greedy approach may not work always as we may miss out on large potential points on some days.
    // We need to find all possible ways using recursion and optimise.
    // Express 
    // Explore
    // Return
    // f(day, last) -> gives the maximum points scored till given day when activity done on previous day was last.
    public int maximumPoints(int arr[][], int N) {
        // return f(N-1, 3, arr);
        
        // int[][] dp = new int[N][4];
        // for(int i=0;i<N;i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        
        // return memoized(N-1, 3, arr, dp);
        // return tabulation(arr);
        return spaceOp(arr);
    }
    
    // O(3 * 2^N)
    // O(N)
    private int f(int day, int last, int[][] arr) {
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i=0;i<3;i++) {
                if (i != last) {
                    max = Math.max(max, arr[0][i]);
                }
            }
            return max;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i=0;i<3;i++) {
            if (i != last) {
                int p = arr[day][i] + f(day-1, i, arr);
                max = Math.max(p, max);
            }
        }
        
        return max;
    }
    
    // O(N*3*4), O(N + N*4)
    private int memoized(int day, int last, int[][] arr, int[][] dp) {
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i=0;i<3;i++) {
                if (i != last) {
                    max = Math.max(max, arr[0][i]);
                }
            }
            return dp[0][last] = max;
        }
        
        if (dp[day][last] != -1) return dp[day][last];
        int max = Integer.MIN_VALUE;
        for (int i=0;i<3;i++) {
            if (i != last) {
                int p = arr[day][i] + memoized(day-1, i, arr, dp);
                max = Math.max(p, max);
            }
        }
        
        return dp[day][last] = max;
    }
    
    // O(N *3*4), O(N*4)
    private int tabulation(int[][] arr) {
        int[][] dp = new int[arr.length][4];
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][1], Math.max(arr[0][2], arr[0][0]));
        
        for (int day=1;day<arr.length;day++) {
            for(int last=0;last<4;last++) {
                int max = Integer.MIN_VALUE;
                for(int task=0;task<3;task++) {
                    if (task != last) {
                        int p = arr[day][task] + dp[day-1][task];
                        max = Math.max(max, p);
                    }
                }
                dp[day][last] = max;
            }
        }
        
        return dp[arr.length -1][3];
    }
    
    // O(N*3*4), O(4)
    private int spaceOp(int[][] arr) {
        int[] dp = new int[4];
        dp[0] = Math.max(arr[0][1], arr[0][2]);
        dp[1] = Math.max(arr[0][0], arr[0][2]);
        dp[2] = Math.max(arr[0][0], arr[0][1]);
        dp[3] = Math.max(arr[0][1], Math.max(arr[0][2], arr[0][0]));
        
        for (int day=1;day<arr.length;day++) {
            int[] temp = new int[4];
            for(int last=0;last<4;last++) {
                int max = Integer.MIN_VALUE;
                for(int task=0;task<3;task++) {
                    if (task != last) {
                        int p = arr[day][task] + dp[task];
                        max = Math.max(max, p);
                    }
                }
                temp[last] = max;
            }
            dp = temp;
        }
        
        return dp[3];
    }
}
