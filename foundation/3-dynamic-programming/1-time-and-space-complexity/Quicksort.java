import java.io.*;
import java.util.*;

public class Quicksort {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        quicksort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void quicksort(int arr[], int lo, int hi) {
        if(lo<=hi) {
            return;
        }

        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);
        quicksort(arr, lo, pi-1);
        quicksort(arr, pi+1, hi);
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

        return j-1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}