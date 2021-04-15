// Leetcode 238

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        for(int i=0;i<n;i++) {
            if(i>0) {
                ans[i] = ans[i-1] * nums[i-1];
            }
            else {
                ans[0] = 1;
            }
        }
        
        int suffixprod = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            ans[i] = ans[i] * suffixprod;
            suffixprod = suffixprod * nums[i];
        }
        
        return ans;
    }
}