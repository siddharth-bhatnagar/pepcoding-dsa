// Leetcode 768
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] prefixmax = new int[n];
        int[] suffixmin = new int[n];
        
        prefixmax[0] = arr[0];
        for(int i=1;i<n;i++){
            prefixmax[i] = Math.max(prefixmax[i-1], arr[i]);
        }
        
        suffixmin[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffixmin[i] = Math.min(suffixmin[i+1], arr[i]);
        }
        
        int chunks = 0;
        for(int i=0;i<n-1;i++){
            if(prefixmax[i] <= suffixmin[i+1])
                chunks++;
        }
        chunks++;
        
        return chunks;
    }
}