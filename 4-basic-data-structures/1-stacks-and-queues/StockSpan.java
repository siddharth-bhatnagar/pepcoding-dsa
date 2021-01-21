import java.io.*;
import java.util.*;

public class StockSpan {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr) {
        int ans[] = new int[arr.length];
        Stack < Integer > stack = new Stack < > ();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && arr[i] > arr[stack.peek()]) {
                int si = stack.pop();
                ans[si] = si - i;
            }
            stack.push(i);
        }
        while (stack.size() > 0) {
            int usi = stack.pop();
            ans[usi] = usi + 1;
        }
        return ans;
    }
}


// This question requires tweaking NGE on left according to what is asked.

/*
--------------------------------Approach---------------------------------

Find the next greatest element to the left in any and find the difference between the current value of i
and the next greatest element on left's index in the given array and store it in ans array.
if NGE is not present, simply place i+1 in the place of that element in the ans array.

**/