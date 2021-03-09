import java.util.*;

public class RingRotate {

    public static void main(String[] args) throws Exception {
        // Create Scanner object
        Scanner scn = new Scanner(System.in);
        // rows
        int n = scn.nextInt();
        // columns
        int m = scn.nextInt();
        // nxm matrix declaration
        int[][] arr = new int[n][m];
        // Filling the matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        // shell number
        int s = scn.nextInt();
        // number of rotations
        int r = scn.nextInt();

        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - 1 - (s - 1);
        int maxc = arr[0].length - 1 - (s - 1);
        int size = 2 * (maxr - minr + 1) + 2 * (maxc - minc + 1) - 4;
        int p = 0;
        int shell[] = new int[size];

        // Left wall
        for (int i = minr; i <= maxr; i++) {
            shell[p] = arr[i][minc];
            p++;
        }
        minc++;
        // Floor
        for (int i = minc; i <= maxc; i++) {
            shell[p] = arr[maxr][i];
            p++;
        }
        maxr--;
        // Right Wall
        for (int i = maxr; i >= minr; i--) {
            shell[p] = arr[i][maxc];
            p++;
        }
        maxc--;
        // Ceiling
        for (int i = maxc; i >= minc; i--) {
            shell[p] = arr[minr][i];
            p++;
        }
        minr++;

        rotate(shell, r);

        minr = s - 1;
        minc = s - 1;
        maxr = arr.length - 1 - (s - 1);
        maxc = arr[0].length - 1 - (s - 1);
        size = 2 * (maxr - minr + 1) + 2 * (maxc - minc + 1) - 4;
        p = 0;

        // Left wall
        for (int i = minr; i <= maxr; i++) {
            arr[i][minc] = shell[p];
            p++;
        }
        minc++;
        // Floor
        for (int i = minc; i <= maxc; i++) {
            arr[maxr][i] = shell[p];
            p++;
        }
        maxr--;
        // Right Wall
        for (int i = maxr; i >= minr; i--) {
            arr[i][maxc] = shell[p];
            p++;
        }
        maxc--;
        // Ceiling
        for (int i = maxc; i >= minc; i--) {
            arr[minr][i] = shell[p];
            p++;
        }
        minr++;

        display(arr);
    }

    public static void rotate(int[] shell, int r) {
        r = r % shell.length;
        if (r < 0) {
            r = r + shell.length;
        }

        reverse(shell, 0, shell.length - 1);
        reverse(shell, 0, r - 1);
        reverse(shell, r, shell.length - 1);
    }

    public static void reverse(int[] shell, int si, int ei) {
        while (si < ei) {
            int temp = shell[si];
            shell[si] = shell[ei];
            shell[ei] = temp;
            si++;
            ei--;
        }
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