// Leetcode 768
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] rightmin = new int[n];
        rightmin[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) {
            rightmin[i] = Math.min(rightmin[i+1], arr[i]);
        }
        int leftmax = Integer.MIN_VALUE;
        int chunks = 0;
        for(int i=0;i<n-1;i++) {
            leftmax = Math.max(leftmax, arr[i]);
            if(leftmax <= rightmin[i+1]) chunks++;
        }
        chunks++;
        
        return chunks;
    }
}

/**

Partition/Chunk - Max array element in the left side of chunk is smaller than or equal to the minimum value to its right

Descending order - chunks = 1
Sorted Array - chunks = n


int n = arr.length;
int[] leftmax = new int[n];
leftmax[0] = arr[0];
for(int i=1;i<n;i++) {
    leftmax[i] = Math.max(leftmax[i-1], arr[i]);
}

int[] rightmin = new int[n];
rightmin[n-1] = arr[n-1];
for(int i=n-2;i>=0;i--) {
    rightmin[i] = Math.min(rightmin[i+1], arr[i]);
}

int chunks = 0;
for(int i=0;i<n-1;i++) {
    if(leftmax[i] <= rightmin[i+1]) chunks++;
}
chunks++;

return chunks;


This can also be achieved without using two arrays

*/