import java.util.*;

public class CrosswordPuzzle {

    public static void solution(char[][] arr, String[] words, int vidx) {
        if (vidx == words.length) {
            print(arr);
            return;
        }

        String word = words[vidx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (checkVertical(arr, word, i, j)) {
                    boolean[] vis = new boolean[word.length()];
                    placeVertical(arr, word, i, j, vis);
                    solution(arr, words, vidx + 1);
                    removeVertical(arr, word, i, j, vis);
                }

                if (checkHorizontal(arr, word, i, j)) {
                    boolean[] vis = new boolean[word.length()];
                    placeHorizontal(arr, word, i, j, vis);
                    solution(arr, words, vidx + 1);
                    removeHorizontal(arr, word, i, j, vis);
                }

            }
        }
    }

    public static void removeVertical(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i = row;
        int idx = 0;
        while (idx < word.length()) {
            if (vis[i] == true) {
                arr[i][col] = '-';
            }
            i++;
            idx++;
        }
    }

    public static void removeHorizontal(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i = col;
        int idx = 0;
        while (idx < word.length()) {
            if (vis[i] == true) {
                arr[row][i] = '-';
            }
            i++;
            idx++;
        }
    }

    public static void placeVertical(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i = row;
        int idx = 0;
        while (idx < word.length()) {
            if (arr[i][col] == '-') {
                vis[idx] = true;
            }
            arr[i][col] = word.charAt(idx);
            i++;
            idx++;
        }
    }

    public static void placeHorizontal(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i = col;
        int idx = 0;
        while (idx < word.length()) {
            if (arr[row][i] == '-') {
                vis[idx] = true;
            }
            arr[row][i] = word.charAt(idx);
            i++;
            idx++;
        }
    }

    public static boolean checkVertical(char[][] arr, String word, int row, int col) {
        int i = row;
        while (i - row < word.length()) {

            if (i == arr.length)
                return false;

            if (arr[i][col] == '-' || arr[i][col] == word.charAt(i - row)) {
                i++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkHorizontal(char[][] arr, String word, int row, int col) {
        int i = col;
        while (i - col < word.length()) {

            if (i == arr[0].length)
                return false;

            if (arr[row][i] == '-' || arr[row][i] == word.charAt(i - col)) {
                i++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }

        solution(arr, words, 0);
    }
}