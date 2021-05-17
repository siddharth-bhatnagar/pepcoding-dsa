// Leetcode 891
// O(nlogn), O(1)
class Solution {
    public int sumSubseqWidths(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        long MOD = 1000000007;
        long pow = 1;
        long ans = 0;
        for(int i=0;i<N;i++) {
            ans = (ans + (A[i]*pow) - (A[N-i-1] *pow)) % MOD;
            pow = pow*2%MOD;
        }
        
        return (int) ans;
    }
}