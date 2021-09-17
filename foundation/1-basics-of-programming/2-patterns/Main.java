import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int HH = scn.nextInt();
        int MM = scn.nextInt();
        int H = scn.nextInt();
        int M = scn.nextInt();

        if(H < HH) H += 24;
        if(M < MM) M += 60;

        int ans = H - HH + M - MM;
        System.out.println(ans);
        scn.close();
    }
}