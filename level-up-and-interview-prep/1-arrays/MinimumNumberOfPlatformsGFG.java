import java.util.*;

public class MinimumNumberOfPlatformsGFG {

    // Driver code
    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep, n));
    }

    // Returns minimum number of platforms reqquired
    public static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, platform = 0, ans = Integer.MIN_VALUE;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform++;
                ans = Math.max(ans, platform);
                i++;
            } else if (arr[i] > dep[j]) {
                j++;
                platform--;
            }
        }

        return ans;
    }
}