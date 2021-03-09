import java.io.*;
import java.util.*;

public class FirstLastIndex {

    public static void main(String[] args) throws Exception {
        // Array is assumed to be sorted
        // Use Binary search for sorted Arrays and recursion for unsorted

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int v = scn.nextInt();
        printFirstAndLastIndex(arr, v);
    }

    public static void printFirstAndLastIndex(int[] arr, int num) {
        int lo = 0;
        int hi = arr.length - 1;
        int first = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == num) {
                first = mid;
                hi = mid - 1;
            } else if (arr[mid] < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(first);

        int last = -1;
        lo = 0;
        hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == num) {
                last = mid;
                lo = mid + 1;
            } else if (arr[mid] > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(last);
    }
}