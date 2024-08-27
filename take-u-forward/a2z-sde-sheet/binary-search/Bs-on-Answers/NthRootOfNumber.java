/*
 * https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
 */
public class NthRootOfNumber {
    // Brute force: iterate from 1 to m, for each value multiply n times and see if it equals m
    // If it becomes greater than m, break out of loop. 
    // Optimisation with binary search
    // Range: [1..m], for each mid, calculate n times, discard search space accordingly.
    public int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, n, m) == 1) {
                return mid;
            } else if (check(mid, n, m) == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
     }
     
     // Return 0 -> mid ^ n < m
     // Return 1 -> mid ^ n == m
     // Return 2 -> mid ^ n > m
     private int check(int mid, int n, int m) {
         long ans=1;
         for (int i=1;i<=n;i++) {
             ans = ans * mid;
             if (ans > m) return 2;
         }
         
         if (ans == m) return 1;
         else return 0;
     }
}
