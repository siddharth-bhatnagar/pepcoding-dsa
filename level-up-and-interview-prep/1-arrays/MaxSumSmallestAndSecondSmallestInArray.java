// GFG 

class Solution {
    public static long pairWithMaxSum(long arr[], long N) {
        if (N < 2)
            return -1;
        long omax = arr[0] + arr[1];
        for (int i = 1; i < N - 1; i++) {
            omax = Math.max(omax, arr[i] + arr[i + 1]);
        }
        return omax;
    }
}
