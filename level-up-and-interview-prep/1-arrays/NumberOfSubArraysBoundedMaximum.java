// Leetcode 795

class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int i=0;
        int prevvalidcount = 0;
        int ans = 0;
        
        for(int j=0;j<A.length;j++){
            if(A[j]>=L&&A[j]<=R){
                ans += (j-i+1);
                prevvalidcount = j-i+1;
            }
            else if(A[j]<L){
                ans+=prevvalidcount;
            }
            else {
                i = j+1;
                prevvalidcount = 0;
            }
        }
        return ans;
    }
}