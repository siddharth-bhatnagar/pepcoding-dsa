import java.io.*;
import java.util.*;

public class BrokenEconomy {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();
        getDenominations(arr, d);
        // Assumption - Array is sorted in non-decreasing order
    }

    public static void getDenominations(int[] arr, int d) {
        int lo = 0;
        int hi = arr.length - 1;
        int ceil = 0, floor = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == d) {
                System.out.println(d);
                return;
            } else if (arr[mid] < d) {
                lo = mid + 1;
                floor = arr[mid];
            } else {
                hi = mid - 1;
                ceil = arr[mid];
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }
}