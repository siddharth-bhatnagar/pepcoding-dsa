import java.io.*;
import java.util.*;

public class LAH {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = largestAreaHistogram(arr);
        System.out.println(ans);
    }

    public static int largestAreaHistogram(int[] arr) {
        int[] lb = NSEonLeft(arr);
        int[] rb = NSEonRight(arr);

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int height = arr[i];
            int area = width * height;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static int[] NSEonLeft(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] NSEonRight(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, arr.length);
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }
}
