// Leetcode 915
// O(n), O(n)
class Solution {
    public int partitionDisjoint(int[] A) {
        int[] prefixmax = new int[A.length];
        prefixmax[0] = A[0];
        for(int i=1;i<A.length;i++) {
            prefixmax[i] = Math.max(prefixmax[i-1], A[i]);
        }
        int suffixmin[] = new int[A.length];
        suffixmin[A.length-1] = A[A.length-1];
        for(int i=A.length-2; i>=0; i--) {
            suffixmin[i] = Math.min(suffixmin[i+1], A[i]);
        }
        int i=0;
        while(i<A.length-1) {
            if(prefixmax[i] <= suffixmin[i+1]){
                break;
            }
            i++;
        }
        return i+1;
    }
}