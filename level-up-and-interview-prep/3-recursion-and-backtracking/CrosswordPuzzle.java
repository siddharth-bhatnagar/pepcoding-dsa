import java.util.*;

public class CrosswordPuzzle {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}

        solvePuzzle(arr, words, 0);
        scn.close();
    }

    public static void display(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solvePuzzle(char[][] arr, String[] words, int idx) {

        if (idx == words.length) {
            display(arr);
            return;
        }

        String word = words[idx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (canPlaceWordHorizontally(arr, word, i, j)) {
                        boolean[] wePlaced = placeWordHorizontally(arr, word, i, j);
                        solvePuzzle(arr, words, idx + 1);
                        removeWordHorizontally(arr, wePlaced, i, j);
                    }

                    if (canPlaceWordVertically(arr, word, i, j)) {
                        boolean[] wePlaced = placeWordVertically(arr, word, i, j);
                        solvePuzzle(arr, words, idx + 1);
                        removeWordVertically(arr, wePlaced, i, j);
                    }
                }
            }
        }
    }

    public static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j) {
        if (j - 1 >= 0 && arr[i][j - 1] != '+')
            return false;
        else if (j + word.length() < arr[0].length && arr[i][j + word.length()] != '+')
            return false;

        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= arr[0].length)
                return false;

            if (arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj))
                continue;
            else
                return false;
        }

        return true;
    }

    public static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {

        if (i - 1 >= 0 && arr[i - 1][j] != '+')
            return false;
        else if (i + word.length() < arr.length && arr[i + word.length()][j] != '+')
            return false;

        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= arr.length)
                return false;
            if (arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii))
                continue;
            else
                return false;
        }

        return true;
    }

    public static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int jj = 0; jj < word.length(); jj++) {
            if (arr[i][j + jj] == '-') {
                arr[i][j + jj] = word.charAt(jj);
                wePlaced[jj] = true;
            }
        }
        return wePlaced;
    }

    public static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int ii = 0; ii < word.length(); ii++) {
            if (arr[i + ii][j] == '-') {
                arr[i + ii][j] = word.charAt(ii);
                wePlaced[ii] = true;
            }
        }
        return wePlaced;
    }

    public static void removeWordHorizontally(char[][] arr, boolean[] wePlaced, int i, int j) {
        for (int jj = 0; jj < wePlaced.length; jj++) {
            if(wePlaced[jj] == true) {
                arr[i][j+jj] = '-';
            }
        }
    }

    public static void removeWordVertically(char[][] arr, boolean[] wePlaced, int i, int j) {
        for (int ii = 0; ii < wePlaced.length; ii++) {
            if(wePlaced[ii] == true) {
                arr[i + ii][j] = '-';
            }
        }
    }
}