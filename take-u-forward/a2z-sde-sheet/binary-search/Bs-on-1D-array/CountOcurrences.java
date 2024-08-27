/*
 * Blog: https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/
 * 
 */
public class CountOcurrences {
    int count(int[] arr, int n, int x) {
        int lb = lowerBound(arr, x, n);
        if (lb == n || arr[lb] != x) return 0;
        int ub = upperBound(arr, x, n);
        int last = ub - 1;
        
        return last - lb + 1;
    }
    
    private int lowerBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int m = low + (high - low) / 2;
            if (arr[m] >= x) {
                ans = m;
                high = m -1;
            } else low = m + 1;
        }

        return ans;
    }

    private int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int m = low + (high - low) / 2;
            if (arr[m] > x) {
                ans = m;
                high = m -1;
            } else low = m + 1;
        }

        return ans;
    }
}
