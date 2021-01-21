import java.io.*;
import java.util.*;

public class Main {
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

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr) {
        int nge[] = new int[arr.length];
        Stack < Integer > stack = new Stack < > ();
        // Arrays.fill(nge, -1); // Fills the array with -1 
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() != 0 && arr[i] > arr[stack.peek()]) {
                nge[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (stack.size() > 0) {
            nge[stack.pop()] = -1;
        }

        return nge;
    }
}


// Next Greatest element on the right is array element whose value is greater than the current element.

/*
    We have to return an array consisting of NGE on right for each value 
    in the given array and if no NGE on right exists, We have to place -1 at that position.

    *******************Approach*****************

    To reduce the complexity of the program, we'll push indices array in the stack.
    if the stack is empty, we'll push index of the element in stack. if the stack is not empty,
    and the element at current array element is greater than the element at the index present on top of stack,
    we will place that value in the ans array and pop the stack till the current value of element in array becomes 
    less than the value of element pointed by index at top of stack or the size of stack becomes zero. Then we'll push the current 
    index in stack. Those indices whose NGe on right could not be found will point to -1 in the ans array.


    This approach can also be modified to find NGE on left as well as NSE on right or left. The time complexity of this algorithm appears to be O(n^2) due to nested loops but is actually O(2n) or simply O(n) in the worst case because the inner loop does not run every time.

    The Arrays.fill(nge, -1) places -1 at each index of nge array. This can also be achieved using a while loop.

    This can be solved using another approach where we will push the last element in the stack and at that position,
    place -1 in the ans array since there is no value at the right of last element in the given array arr.
    Then we will use  pop,ans,push steps. The code for this approach is given below.

    public static void NGEOnRight(int arr[]){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        ans[arr.length-1] = -1;
        stack.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            
            while(stack.size()>0&&arr[i] >= stack.peek()){
                stack.pop();
            }
            
            if(stack.size()==0){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            
            stack.push(arr[i])
        }
        return ans;
    }


To Find NSE on right, NSE on left, NGE on left we only need to tweak this code

    **/