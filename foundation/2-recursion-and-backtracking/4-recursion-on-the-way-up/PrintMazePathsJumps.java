import java.io.*;
import java.util.*;

public class PrintMazePathsJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(0, 0, n - 1, m - 1, "");
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr==dr && sc == dc){
            System.out.println(psf);
            return;
        }
        if(sr>dr||sc>dc){
            return;
        }
        
        for(int j=1;j<=dc-sc;j++){
            printMazePaths(sr,sc+j,dr,dc,psf+'h'+j);
        }
        
        for(int j=1;j<=dr-sr;j++){
            printMazePaths(sr+j,sc,dr,dc,psf+'v'+j);
        }
        
        for(int j=1;j<=dr-sr && j<=dc-sc;j++){
            printMazePaths(sr+j,sc + j,dr,dc,psf+'d'+j);
        }
        
    }

}