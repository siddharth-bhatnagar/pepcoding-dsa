import java.io.*;
import java.util.*;

public class Quickselect {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k= scn.nextInt();
        int val = quickselect(arr, 0, arr.length - 1, k-1);
        System.out.println(val);
    }

    public static int quickselect(int arr[], int lo, int hi, int k) {
    
        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);
        if(pi==k){
            return arr[pi];
        }
        else if(pi < k) {
            return quickselect(arr, pi+1, hi, k);
        }
        else {
            return quickselect(arr, lo, pi-1, k);
        }
     
    }

    public static int partition(int[] arr, int pivot, int lo, int hi) {
        int i = lo;
        int j = lo;
        while (i <= hi) {
            if (arr[i] > pivot) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }

        return j - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}