class Solution {
    public int maxArea(int[] arr) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int cap = (j - i) * Math.min(arr[i], arr[j]);
            max = Math.max(max, cap);
            if (arr[i] < arr[j])
                i++;
            else
                j--;
        }
        return max;
    }
}

/**
 * Brute force int omax = Integer.MIN_VALUE; for(i=0 to i=n-1){ for(j=i+1 to
 * n-1){ cap = (j-i)*min(arr[j],arr[i]); omax = max(omax, cap); } }
 * 
 * return omax;
 * 
 * time - O(n^2); space = O(1)
 * optimal - O(n), O(1)
 */