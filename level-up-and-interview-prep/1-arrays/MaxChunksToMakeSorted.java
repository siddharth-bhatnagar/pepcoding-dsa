// Leetcode 769
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxidx = Integer.MIN_VALUE;
        int chunks = 0;
        
        for(int i=0;i<arr.length;i++){
            maxidx=Math.max(maxidx, arr[i]);
            
            if(i==maxidx){
                chunks++;
            }
        }
        
        return chunks;
    }
}