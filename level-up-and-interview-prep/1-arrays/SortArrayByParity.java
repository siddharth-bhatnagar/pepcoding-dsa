// Leetcode 905

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            int num1 = A[i];
            int num2 = A[j];

            if (num1 % 2 == 0) {
                i++;
            } else if (num2 % 2 != 0) {
                j--;
            } else {
                swap(A, i, j);
                i++;
                j--;
            }
        }

        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
