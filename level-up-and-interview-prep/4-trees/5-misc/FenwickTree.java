import java.io.*;
import java.util.*;
import java.lang.*;

public class FenwickTree {
    public static void main(String[] args) {
        int test = 1;
        StringBuilder sb = new StringBuilder();
        while (test-- > 0) {
            solve(sb);
        }
        System.out.println(sb);
    }

    private static long[] fenwick;
    private static void solve(StringBuilder sb) {
        FastReader scn = new FastReader();
        int n = scn.nextInt();
        
        long[] arr = new long[n+1];
        long[] prefixsum = new long[n+1];

        for(int i=1;i<=n;i++) {
            arr[i] = scn.nextInt();
            prefixsum[i] = arr[i] + prefixsum[i-1];
        }

        fenwick = new long[n+1];
        for(int i=1;i<=n;i++) {
            // O(N)  
            int k = i - (i & -i);
            fenwick[i] = prefixsum[i] - prefixsum[k];
            
            // O(NlogN)
            // update(i, arr[i]);
        }

        int q = scn.nextInt();
        for(int i=1;i<=q;i++) {
            String[] s = scn.nextLine().split(" ");
            if(s[0].equals("q") || s[0].equals("Q")) {
                int k = Integer.parseInt(s[1]);
                int l = Integer.parseInt(s[2]);

                long res = query(k, l);
                sb.append(res + "\n");
            }
            else {
                int idx = Integer.parseInt(s[1]);
                long delta = Long.parseLong(s[2]);

                arr[idx] += delta;
                update(idx, delta);
            }
        }
    }

    private static long query(int k, int l) {
        return prefixSum(l) - prefixSum(k-1);
    }

    private static long prefixSum(int idx) {
        long sum = 0;
        while(idx > 0) {
            sum += fenwick[idx];
            idx = idx - (idx & -idx);
        }
        return sum;
    }

    private static void update(int idx, long delta) {
        while(idx < fenwick.length) {
            fenwick[idx] += delta;
            idx = idx + (idx & -idx);
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}