// Coding Style 1
import java.io.*;
import java.util.*;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        //write your code here
        // First loop controls the number of iterations, in bb, iter = n-1;
        // The inner loop controls the comparisons, comp = arr.length-iter
        for (int itr = 1; itr <= arr.length - 1; itr++) {
            for (int comp = 0; comp < arr.length - itr; comp++) {
                if (isSmaller(arr, comp + 1, comp) == true) {
                    swap(arr, comp + 1, comp);
                }
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // return true if ith element is smaller than jth element
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        bubbleSort(arr);
        print(arr);
    }

}

/*
-------- Coding Style 2------------

import java.util.Scanner;

public class Main {

    public static void bubble(int arr[], int n) {
        int noi = arr.length - 1;
        for (int itr = 1; itr <= noi; itr++) {
            int noc = arr.length - itr;
            for (int c = 0; c < noc; c++) {
                if (arr[c] > arr[c + 1]) {
                    int temp = arr[c];
                    arr[c] = arr[c + 1];
                    arr[c + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = s.nextInt();
        }

        bubble(ar, n);
        for (int val: ar)
            System.out.print(val + " ");
    }
}

*/