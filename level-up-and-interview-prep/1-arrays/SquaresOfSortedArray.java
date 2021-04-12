// Leetcode 977
class Solution {
    // public int[] sortedSquares(int[] arr) {
    // for(int i=0;i<arr.length;i++){
    // arr[i] = arr[i]*arr[i];
    // }
    // Arrays.sort(arr);
    // return arr;
    // }

    // Above approach is brute force, O(nlogn)

    // Below is O(n) approach using two pointer
    public int[] sortedSquares(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int[] ssq = new int[j + 1];

        int k = j;

        while (i <= j) {
            int sqi = arr[i] * arr[i];
            int sqj = arr[j] * arr[j];
            ssq[k] = Math.max(sqi, sqj);
            if (sqi < sqj) {
                j--;
            } else {
                i++;
            }
            k--;
        }
        return ssq;
    }

}
