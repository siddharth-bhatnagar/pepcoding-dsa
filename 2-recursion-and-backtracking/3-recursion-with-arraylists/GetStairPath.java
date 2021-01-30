import java.io.*;
import java.util.*;

public class GetStairPath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList < String > a = getStairPaths(n);
        System.out.println(a);
    }

    public static ArrayList < String > getStairPaths(int n) {
        if (n < 0) {
            ArrayList < String > temp = new ArrayList < > ();
            return temp;
        }
        if (n == 0) {
            ArrayList < String > temp = new ArrayList < > ();
            temp.add("");
            return temp;
        }

        ArrayList < String > smallres1 = getStairPaths(n - 1);
        ArrayList < String > smallres2 = getStairPaths(n - 2);
        ArrayList < String > smallres3 = getStairPaths(n - 3);

        ArrayList < String > ans = new ArrayList < > ();

        for (int i = 0; i < smallres1.size(); i++) {
            ans.add("1" + smallres1.get(i));
        }
        for (int i = 0; i < smallres2.size(); i++) {
            ans.add("2" + smallres2.get(i));
        }

        for (int i = 0; i < smallres3.size(); i++) {
            ans.add("3" + smallres3.get(i));
        }

        return ans;
    }
}