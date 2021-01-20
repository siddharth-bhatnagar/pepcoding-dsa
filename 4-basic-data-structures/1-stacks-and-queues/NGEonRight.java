import java.io.*;
import java.util.*;

public class NGEonRight {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
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

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr) {
        int ans[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        // Arrays.fill(ans, -1);

        for (int i = 0; i < arr.length; i++) {

            while (stack.size() != 0 && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);

        }
        while (stack.size() != 0) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

}


// Next smallest element on right

// public static int[] solve(int[] arr) {
//     int nge[] = new int[arr.length];
    
//     Stack <Integer> stack = new Stack<>();
//     Arrays.fill(nge, -1);
//     for(int i = 0;i<arr.length;i++){
//         while(stack.size()!=0 && arr[i]<arr[stack.peek()]){
//             int solvedidx = stack.pop();
//             nge[solvedidx] = arr[i];
//         }
//         stack.push(i);
//     }
//     return nge;
// }

// next greatest on left

// public static int[] solve(int[] arr) {
//     int nge[] = new int[arr.length];
    
//     Stack <Integer> stack = new Stack<>();
//     Arrays.fill(nge, -1);
//     for(int i = arr.length-1;i>=0;i--){
//         while(stack.size()!=0 && arr[i]>arr[stack.peek()]){
//             int solvedidx = stack.pop();
//             nge[solvedidx] = arr[i];
//         }
//         stack.push(i);
//     }
//     return nge;
// }


// next smallest on left

// public static int[] solve(int[] arr) {
//     int nge[] = new int[arr.length];
    
//     Stack <Integer> stack = new Stack<>();
//     Arrays.fill(nge, -1);
//     for(int i = arr.length-1;i>=0;i--){
//         while(stack.size()!=0 && arr[i]<arr[stack.peek()]){
//             int solvedidx = stack.pop();
//             nge[solvedidx] = arr[i];
//         }
//         stack.push(i);
//     }
//     return nge;
// }



// Complexity is O(n)