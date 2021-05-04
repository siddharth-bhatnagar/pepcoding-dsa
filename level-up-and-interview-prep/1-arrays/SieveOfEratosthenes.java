import java.util.ArrayList;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> ans = sieveOfEratosthenes(n); // O(NloglogN) approx O(N)
        System.out.println(ans);
        scn.close();
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int N) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] arr = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++) {
            if(arr[i] == false) {
                for(int j=i*i; j <= N; j+=i) {
                    arr[j] = true;
                }
            }
        }

        for(int i=2;i<=N;i++) {
            if(arr[i] == false) {
                ans.add(i);
            }
        }

        return ans;
    }
}