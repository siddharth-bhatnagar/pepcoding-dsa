import java.util.*;

public class SpiralDisplay {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        spiralDisplay(n, m, arr);
    }

    public static void spiralDisplay(int r, int c, int[][] arr) {

        int maxr = r - 1;
        int maxc = c - 1;
        int minr = 0;
        int minc = 0;
        int total = r * c;
        int count = 0;
        while (count < total) {

            // Left Wall
            for (int i = minr; i <= maxr && count < total; i++) {
                System.out.println(arr[i][minc]);
                count++;
            }
            minc++;

            // Bottom Wall
            for (int i = minc; i <= maxc && count < total; i++) {
                System.out.println(arr[maxr][i]);
                count++;
            }
            maxr--;

            // Right Wall
            for (int i = maxr; i >= minr && count < total; i--) {
                System.out.println(arr[i][maxc]);
                count++;
            }
            maxc--;

            // Upper Wall
            for (int i = maxc; i >= minc && count < total; i--) {
                System.out.println(arr[minr][i]);
                count++;
            }
            minr++;
        }

    }

}