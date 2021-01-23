import java.io.*;
import java.util.*;

public class LastIndex {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        System.out.println(lastIndex(arr, n - 1, x));
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx < 0) {
            return -1;
        }
        if (arr[idx] == x) {
            return idx;
        }
        int ans = lastIndex(arr, idx - 1, x);
        return ans;
    }
}