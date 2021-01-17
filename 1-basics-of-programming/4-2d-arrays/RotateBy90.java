import java.io.*;
import java.util.*;

public class RotateBy90 {

    public static void main(String[] args) throws Exception {
        // Create and fill a square matrix
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        // Transpose of matrix , traversal in upper triangle

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Reversing the matrix row wise

        for (int i = 0; i < arr.length; i++) {
            int si = 0;
            int ei = arr[0].length - 1;
            while (si < ei) {

                int temp = arr[i][si];
                arr[i][si] = arr[i][ei];
                arr[i][ei] = temp;

                si++;
                ei--;
            }
        }

        display(arr);
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}