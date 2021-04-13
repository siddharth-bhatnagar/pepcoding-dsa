// leetcode 169

// Boyer Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] arr) {
        int val = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == val) {
                count++;
            } else if (count == 0) {
                val = arr[i];
                count = 1;
            } else {
                count--;
            }
        }
        return val;
    }
}