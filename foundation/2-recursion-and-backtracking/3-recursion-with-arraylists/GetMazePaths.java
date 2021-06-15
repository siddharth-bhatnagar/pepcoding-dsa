import java.util.*;

public class GetMazePaths {

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

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList < String > temp = new ArrayList < > ();
            temp.add("");
            return temp;
        }
        if (sr > dr || sc > dc) {
            ArrayList < String > temp = new ArrayList < > ();
            return temp;
        }

        ArrayList < String > smallres1 = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList < String > smallres2 = getMazePaths(sr + 1, sc, dr, dc);

        ArrayList < String > answer = new ArrayList < > ();

        for (int i = 0; i < smallres1.size(); i++) {
            answer.add("h" + smallres1.get(i));
        }

        for (int i = 0; i < smallres2.size(); i++) {
            answer.add("v" + smallres2.get(i));
        }

        return answer;
    }

}