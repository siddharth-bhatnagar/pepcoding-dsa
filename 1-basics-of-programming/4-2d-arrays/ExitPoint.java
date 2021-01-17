import java.io.*;
import java.util.*;

public class ExitPoint {
    public static Scanner scn = new Scanner(System.in);

    // This is a functional problem.
    // Input is managed for you.
    // Don't change main, write your code in the function below
    public static void main(String[] args) {
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }

        }
        exitPoint(arr);
    }

    public static void exitPoint(int[][] arr) {
        int dir = 0; // 0-east ,1-south ,2-west ,3-north
        int i = 0, j = 0;

        while (true) {
            dir = (dir + arr[i][j]) % 4;
            if (dir == 0) {
                j++;
            } else if (dir == 1) {
                i++;
            } else if (dir == 2) {
                j--;
            } else {
                i--;
            }
        }

        System.out.println(i + ", " + j);
    }
}