/**
 * Upper and Lower Bound
 * Ceil and Floor
 * 
 * Blogs: https://takeuforward.org/arrays/implement-lower-bound-bs-2/
 *  https://takeuforward.org/arrays/implement-upper-bound/
 * https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/
 */
public class CeilTheFloor {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // Arrays.sort(arr);
        int low=0;
        int high=arr.length-1;
        int[] res = {-1, -1};
        int ans = arr.length;
        // ceil -> smallest element in arr, greater or equal x aka lower bound
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        
        if (ans != arr.length)
            res[1] = arr[ans];
        low = 0; 
        high = arr.length - 1;
        ans = -1;
        
        // floor -> largest element smaller than or equal x
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        
        if (ans != -1)
            res[0] = arr[ans];
        
        return res;
        // int res[] = new int[2];
        // res[0] = findFloor(arr, arr.length, x);
        // res[1] = findCeil(arr, arr.length, x);
        
        // return res;
    }
    
    private int findFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = arr[mid];
                //look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }
    
    private int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = arr[mid];
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        
        return ans;
    }    
}
