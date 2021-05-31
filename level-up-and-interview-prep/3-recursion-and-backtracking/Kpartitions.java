import java.util.*;

public class Kpartitions {

    public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
        // write your code here

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(1, n, k, 0, ans);
        scn.close();
    }

}