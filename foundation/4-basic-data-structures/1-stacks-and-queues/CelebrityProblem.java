import java.io.*;
import java.util.*;

public class CelebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int x = stack.pop();
            int y = stack.pop();

            if (arr[x][y] == 1) {
                // if x knows y -> x can't be celeb
                stack.push(y);
            } else {
                // if y knows x -> y can't be celeb
                stack.push(x);
            }
        }
        // verifying the portential celeb
        int pot = stack.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != pot) {
                if (arr[pot][i] == 1 || arr[i][pot] == 0) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);
    }
}