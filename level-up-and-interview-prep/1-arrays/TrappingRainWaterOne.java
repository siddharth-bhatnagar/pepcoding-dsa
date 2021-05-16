// Leetcode 42
class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        if(n==0) return 0;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = arr[0];
        for(int i=1;i<n;i++) {
            leftmax[i] = Math.max(leftmax[i-1], arr[i]);
        }
        
        rightmax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) {
            rightmax[i] = Math.max(rightmax[i+1], arr[i]);
        }
        
        int water = 0;
        for(int i=1;i<n-1;i++) {
            int cap = Math.min(leftmax[i],rightmax[i]) - arr[i];
            water += cap;
        }
        
        return water;
    }
}

// O(n) time, O(n) space
// Can be optimised to O(1) space

// O(1) space
class Solution {
    public int trap(int[] height) {
        int i=0;
        int j= height.length-1;
        int prefixmax=0;
        int suffixmax=0;
        
        int ans=0;
        while(i<j) {
            prefixmax = Math.max(prefixmax, height[i]);
            suffixmax = Math.max(suffixmax, height[j]);
            
            if(prefixmax <= suffixmax) {
                ans +=  prefixmax - height[i];
                i++;
            }
            else {
                ans += suffixmax - height[j];
                j--;
            }
        }
        
        return ans;
    }
}