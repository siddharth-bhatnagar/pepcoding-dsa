import java.io.*;
import java.util.*;

public class Subarray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        printSubarray(arr);
    }

    public static void printSubarray(int[] arr) {
        for (int si = 0; si < arr.length; si++) {
            for (int ei = si; ei < arr.length; ei++) {
                for (int i = si; i <= ei; i++) {
                    System.out.print(arr[i] + "\t");
                }
                System.out.println();
            }
        }
    }
}

// total subarrays in array of length n => n*(n+1)/2