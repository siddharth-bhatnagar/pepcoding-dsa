
// Spoj problem: Segmented Sieve
import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int m = scn.nextInt();
            int n = scn.nextInt();

            ArrayList<Integer> primes = sieve((int) Math.pow(n, 0.5));
            // System.out.print(primes);
            ArrayList<Integer> ans = segmentedSieve(primes, m, n);
            for (int val : ans) {
                System.out.println(val);
            }
            System.out.println();
        }
        scn.close();
    }

    public static ArrayList<Integer> sieve(int N) {

        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] arr = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++) {
            if (arr[i] == false) {
                for (int j = i * i; j <= N; j += i) {
                    arr[j] = true;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (arr[i] == false) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static ArrayList<Integer> segmentedSieve(ArrayList<Integer> primes, int m, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] arr = new boolean[n-m + 1];
     
        for(int i=0;i<primes.size();i++) {
            int prime = primes.get(i);
            int idx = m - (m/prime) * prime;
            for(int j=idx; j<arr.length-1;j+=prime) {
                arr[j] = true;
            }
        }
        System.out.println(arr);
        for(int i=0;i<arr.length;i++) {
            if(!arr[i]){
                ans.add(m+i);
            }
        }

        return ans;
    }
}