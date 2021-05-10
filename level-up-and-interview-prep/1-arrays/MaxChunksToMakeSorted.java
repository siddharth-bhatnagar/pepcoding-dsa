// Leetcode 769
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int maxElem = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            maxElem = Math.max(maxElem, arr[i]);
            if(i == maxElem) {
                chunks++;
            }
        }
        
        return chunks;
    }
}

/**

Brute force - Optimal O(n), O(1)

- If the array was sorted, then max chunks = n-1, where n is the size of array
- If the array was in descending order, max chunks = 1

Intuition: Every element wants to reach at an index = element value to become sorted.
the index before every partition represents maximum element in that partition.

*/