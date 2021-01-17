import java.io.*;
import java.util.*;

public class BarChart {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = scn.nextInt();
        }

        barChart(arr);
    }

    public static void barChart(int[] arr) {
        int max = maxOfArray(arr);
        for(int floor=max;floor>=1;floor--){
            for(int i=0;i<arr.length;i++){
                if(arr[i]>=floor){
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
    
    public static int maxOfArray(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=arr.length-1;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        
        return max;
    }
}


// for arr = 3,1,0,7,5

// 			     *		
// 			     *		
// 			     *	*	
// 			     *	*	
// *		    *	*	
// *		    *	*	
// *	*	    *	*	












