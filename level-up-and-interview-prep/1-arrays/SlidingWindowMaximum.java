// Leetcode 239
// DP approach, O(3N-k) time O(3N-k) space
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] ans = new int[N-k+1];
        int[] prefixmax = new int[N];
        int[] suffixmax = new int[N];
        for(int i=0;i<N;i++) {
            if(i%k == 0) {
                prefixmax[i] = nums[i];
            }
            else {
                prefixmax[i] = Math.max(prefixmax[i-1], nums[i]);
            }
        }
        
        suffixmax[N-1] = nums[N-1];
        for(int i=N-2;i >= 0;i--) {
            if((i+1)%k == 0) {
                suffixmax[i] = nums[i];
            }
            else {
                suffixmax[i] = Math.max(suffixmax[i+1], nums[i]);
            }
        }
        
        for(int i=0;i<ans.length;i++) {
            ans[i] = Math.max(suffixmax[i], prefixmax[i+k-1]);
        }
        
        return ans;
    }
}

// Can be also done using deque or a monotonic queue