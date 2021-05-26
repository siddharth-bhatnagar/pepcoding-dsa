import java.util.*;

public class Magnets {

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int countInColumn(char ans[][], char ch, int j) {
        int count = 0;
        for (int i = 0; i < ans.length; i++)
            if (ans[i][j] == ch)
                count++;

        return count;
    }

    private static int countInRow(char ans[][], char ch, int i) {
        int count = 0;
        for (int j = 0; j < ans[0].length; j++)
            if (ans[i][j] == ch)
                count++;

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        char[][] arr = new char[m][n];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = scn.nextInt();
        }
        int[] left = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = scn.nextInt();
        }
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            right[i] = scn.nextInt();
        }
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            bottom[i] = scn.nextInt();
        }

        char ans[][] = new char[m][n];

        for (int i = 0; i < m; i++)
            Arrays.fill(ans[i], 'X');

        if (!solution(arr, top, left, right, bottom, ans, 0, 0)) {
            System.out.println("No Solution");
            return;
        }

        print(ans);
    }

    public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans,
            int row, int col) {

        if (col >= arr[0].length) {
            col = 0;
            row++;
        }
        if (row >= arr.length) {
            // print(ans);
            // System.out.println("--------------------------");
            if (isValid(ans, top, left, right, bottom)) {
                return true;
            } else {
                return false;
            }

        }

        if (ans[row][col] == 'X') {
            if (col < arr[0].length - 1 && arr[row][col] == 'L' && arr[row][col + 1] == 'R') {
                // check if it is safe to place
                if (isSafe(ans, row, col, '+', top, left, right, bottom)
                        && isSafe(ans, row, col + 1, '-', top, left, right, bottom)) {
                    // place it
                    ans[row][col] = '+';
                    ans[row][col + 1] = '-';
                    // recursive call
                    if (solution(arr, top, left, right, bottom, ans, row, col + 2)) {
                        return true;
                    }
                    // unplace it
                    ans[row][col] = 'X';
                    ans[row][col + 1] = 'X';
                }
                if (isSafe(ans, row, col, '-', top, left, right, bottom)
                        && isSafe(ans, row, col + 1, '+', top, left, right, bottom)) {
                    // place it
                    ans[row][col] = '-';
                    ans[row][col + 1] = '+';
                    // recursive call
                    if (solution(arr, top, left, right, bottom, ans, row, col + 2)) {
                        return true;
                    }
                    // unplace it
                    ans[row][col] = 'X';
                    ans[row][col + 1] = 'X';
                }
            }

            if (row < arr.length - 1 && arr[row][col] == 'T' && arr[row + 1][col] == 'B') {
                if (isSafe(ans, row, col, '+', top, left, right, bottom)
                        && isSafe(ans, row + 1, col, '-', top, left, right, bottom)) {
                    // place it
                    ans[row][col] = '+';
                    ans[row + 1][col] = '-';
                    // recursive call
                    if (solution(arr, top, left, right, bottom, ans, row, col + 1)) {
                        return true;
                    }
                    // unplace it
                    ans[row][col] = 'X';
                    ans[row + 1][col] = 'X';
                }
                if (isSafe(ans, row, col, '-', top, left, right, bottom)
                        && isSafe(ans, row + 1, col, '+', top, left, right, bottom)) {
                    // place it
                    ans[row][col] = '-';
                    ans[row + 1][col] = '+';
                    // recursive call
                    if (solution(arr, top, left, right, bottom, ans, row, col + 1)) {
                        return true;
                    }
                    // unplace it
                    ans[row][col] = 'X';
                    ans[row + 1][col] = 'X';
                }
            }
        }
        if (solution(arr, top, left, right, bottom, ans, row, col + 1))
            return true;

        return false;
    }

    public static boolean isSafe(char[][] ans, int row, int col, char ch, int[] top, int[] left, int[] right,
            int[] bottom) {
        if ((ans[row][col] != 'X') || (row - 1 >= 0 && ans[row - 1][col] == ch)
                || (row + 1 < ans.length && ans[row + 1][col] == ch) || (col - 1 >= 0 && ans[row][col - 1] == ch)
                || (col + 1 < ans[0].length && ans[row][col + 1] == ch)) {
            return false;
        }
        int rowCount = countInRow(ans, ch, row);
        int colCount = countInColumn(ans, ch, col);

        // if given character is '+', check top[] & left[]
        if (ch == '+') {
            if (top[col] != -1 && colCount >= top[col])
                return false;

            if (left[row] != -1 && rowCount >= left[row])
                return false;
        }

        // if given character is '-', check bottom[] & right[]
        if (ch == '-') {
            if (bottom[col] != -1 && colCount >= bottom[col])
                return false;

            if (right[row] != -1 && rowCount >= right[row])
                return false;
        }
        return true;
    }

    public static boolean isValid(char[][] ans, int[] top, int[] left, int[] right, int[] bottom) {

        for (int i = 0; i < top.length; i++) {
            if (top[i] != -1 && countInColumn(ans, '+', i) != top[i]) {
                return false;
            }
        }

        for (int i = 0; i < left.length; i++) {
            if (left[i] != -1 && countInRow(ans, '+', i) != left[i]) {
                return false;
            }
        }

        for (int i = 0; i < bottom.length; i++) {
            if (bottom[i] != -1 && countInColumn(ans, '-', i) != bottom[i]) {
                return false;
            }
        }

        for (int i = 0; i < right.length; i++) {
            if (right[i] != -1 && countInRow(ans, '-', i) != right[i]) {
                return false;
            }
        }

        return true;
    }

}