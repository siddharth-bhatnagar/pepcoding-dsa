import java.util.List;

/**
 * Blog: https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/
 * Key insight is that if find out the position of the min element in rotated sorted array, 
 * that will be the number of times the array was rotated
 */
public class CountNumberOfTimesArrayWasRotated {
    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        int low = 0, high = n - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) <= min) {
                    min = arr.get(low);
                    index = low;
                }
                low = mid + 1;
            } else {
                if (arr.get(mid) <= min) {
                    min = arr.get(mid);
                    index = mid;
                }
                high = mid - 1;
            }
        }
        
        return index;
    }
}
