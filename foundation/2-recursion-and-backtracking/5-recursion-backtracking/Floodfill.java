import java.io.*;
import java.util.*;

public class Floodfill {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        
         floodfill(arr, 0,0,new boolean[n][m], "");
    }

   



public static void floodfill(int[][] maze, int sr, int sc, boolean[][] val, String psf) {
        if(sr<0||sc<0||sr>=maze.length||sc>=maze[0].length||maze[sr][sc]==1||val[sr][sc]==true){
            return;
        }
        if(sr==maze.length-1&&sc==maze[0].length-1){
            System.out.println(psf);
            return;
        }
        val[sr][sc] = true;
        floodfill(maze, sr-1,sc,val,psf+"t");
        floodfill(maze, sr,sc-1,val,psf+"l");
        floodfill(maze, sr+1,sc,val,psf+"d");
        floodfill(maze, sr,sc+1,val,psf+"r");
        val[sr][sc] = false;
    }
}

