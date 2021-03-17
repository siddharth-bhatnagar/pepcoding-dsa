import java.io.*;
import java.util.*;
// Expected complexity is O(nlogK).
public class KLargestElements {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // write your code here

        kLargestElements(arr, k);
    }

    public static void kLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++) {
            if(i<k){
                pq.add(arr[i]);
            }
            else{
                if(arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        while(pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }

}