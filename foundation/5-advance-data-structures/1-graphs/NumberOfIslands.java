import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < arr.length; i++) {
            String lines = br.readLine();
            String[] line = lines.split(" ");
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && visited[i][j] == false) {
                    numberOfIsland(arr, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void numberOfIsland(int[][] arr, int i, int j, boolean[][] visited) {
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] == 1 || visited[i][j] == true) {
            return;
        }
        
        visited[i][j] = true;
        numberOfIsland(arr, i - 1, j, visited);
        numberOfIsland(arr, i, j - 1, visited);
        numberOfIsland(arr, i + 1, j, visited);
        numberOfIsland(arr, i, j + 1, visited);
    }

}