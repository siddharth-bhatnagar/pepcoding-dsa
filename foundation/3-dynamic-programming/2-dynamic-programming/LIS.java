class LIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;

        for (int ei = 1; ei < nums.length; ei++) {
            for (int si = 0; si < ei; si++) {
                if (nums[ei] > nums[si]) {
                    dp[ei] = Math.max(dp[ei], dp[si] + 1);
                    ans = Math.max(ans, dp[ei]);
                }
            }
        }
        return ans;
    }

     int fans;
    public int helper(int[] arr, int ei, int[] dp) {
        if(ei==0){
            return 1;
        }
        
        if(dp[ei]!=0){
            return dp[ei];
        }
        
        int omax = 1;
        for(int si = 0; si < ei; si++){
            int temp = helper(arr, si, dp);
            
            if(arr[si] < arr[ei] && temp + 1 > omax){
                omax = temp + 1;
            }
        }
        
        fans = Math.max(fans, omax);
        dp[ei] = omax;
        return omax;
    }
}