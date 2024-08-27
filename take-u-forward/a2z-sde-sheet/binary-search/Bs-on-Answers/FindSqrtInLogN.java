/**
 * Blog: https://takeuforward.org/binary-search/finding-sqrt-of-a-number-using-binary-search/
 * 
 */
public class FindSqrtInLogN {
    long floorSqrt(long n) {
        long low = 1;
        long high = n;
        long ans=1;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            if (mid*mid <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}


// 36 -> 1x1, 2x2,3x3...
// x*x <= n
// O(N)
// Range [1...N]
// BS -> if x*x <= n, then discard left half, if greater discard right half.


