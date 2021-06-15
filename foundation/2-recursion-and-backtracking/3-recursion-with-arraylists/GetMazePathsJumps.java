import java.util.*;

public class GetMazePathsJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int sr = 0;
        int sc = 0;
        int dr = n - 1;
        int dc = m - 1;
        ArrayList < String > ans = getMazePaths(sr, sc, dr, dc);
        System.out.println(ans);
        scn.close();
    }

    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList < String > temp = new ArrayList < > ();
            temp.add("");
            return temp;
        }

        ArrayList < String > answer = new ArrayList < > ();

        for (int j = 1; j <= dc - sc; j++) {
            ArrayList < String > smallres1 = getMazePaths(sr, sc + j, dr, dc);
            for (int i = 0; i < smallres1.size(); i++) {
                answer.add("h" + j + smallres1.get(i));
            }
        }

        for (int j = 1; j <= dr - sr; j++) {
            ArrayList < String > smallres2 = getMazePaths(sr + j, sc, dr, dc);
            for (int i = 0; i < smallres2.size(); i++) {
                answer.add("v" + j + smallres2.get(i));
            }
        }

        for (int j = 1; j <= Math.min(dc - sc, dr - sr); j++) {
            ArrayList < String > smallres3 = getMazePaths(sr + j, sc + j, dr, dc);
            for (int i = 0; i < smallres3.size(); i++) {
                answer.add("d" + j + smallres3.get(i));
            }
        }

        return answer;
    }

}