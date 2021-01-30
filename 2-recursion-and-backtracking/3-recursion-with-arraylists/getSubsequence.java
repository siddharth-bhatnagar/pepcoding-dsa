import java.io.*;
import java.util.*;

public class GetSubsequence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(gss(str));
    }

    public static ArrayList < String > gss(String str) {

        if (str.length() == 0) {
            ArrayList < String > temp = new ArrayList < > ();
            temp.add("");
            return temp;
        }

        char fc = str.charAt(0);
        String ros = str.substring(1);
        ArrayList < String > smallans = gss(ros);
        ArrayList < String > result = new ArrayList < > ();

        for (int i = 0; i < smallans.size(); i++) {
            result.add("" + smallans.get(i));
        }

        for (int i = 0; i < smallans.size(); i++) {
            result.add(fc + smallans.get(i));
        }

        return result;
    }
}