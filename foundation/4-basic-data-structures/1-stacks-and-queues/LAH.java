import java.io.*;
import java.util.*;

public class LAH {


    public static void main(String[] args) throws Exception {
        // creating buffered reader object
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking integer input as string and parsing it
        int n = Integer.parseInt(br.readLine());

        //  declaring input array
        int[] arr = new int[n];

        // Filling the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        largestAreaHistogram(arr);
    }

    public static void largestAreaHistogram(int[] arr) {
        // Creating arrays to catch the NSEs for the whole array. 
        int[] lb = NSEOnLeft(arr);
        int[] rb = NSEOnRight(arr);
        
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = rb[i] - lb[i] - 1;
            int correspondingArea = height * width;
            if(correspondingArea > maxArea){
                maxArea = correspondingArea;
            }
        }
        System.out.println(maxArea);
    }

    public static int[] NSEOnLeft(int[] arr) {
        int ans[] = new int[arr.length];
        Stack < Integer > stack = new Stack < > ();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (stack.size() > 0) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

    public static int[] NSEOnRight(int[] arr) {
        int ans[] = new int[arr.length];
        Stack < Integer > stack = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (stack.size() > 0) {
            ans[stack.pop()] = arr.length;
        }
        return ans;
    }
}



// This problem requires us to find the largest area formed by the rectangles present in the histogram.

// -----------------------------------Approach---------------------------------------

/*

The width of each bar in the histogram is 1 unit.
The height of each bar is given in the array.

Idea is to find the NSE element on right and NSE on left corresponding to each height in the array.
The maximum width for each height can be calculated as the difference between the two NSEs. 
corresponding area is height*width for that height, find the maximum one and print it.

**/