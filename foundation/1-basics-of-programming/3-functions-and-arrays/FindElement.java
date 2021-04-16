import java.io.*;
import java.util.*;

public class FindElement {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int d = scn.nextInt();
        int ans = findElement(arr, d);
        System.out.println(ans);
    }

    public static int findElement(int[] arr, int d) {
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == d) {
                idx = i;
                break;
            }
        }
        
        return idx;
    }
}