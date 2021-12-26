import java.util.*;
import java.io.*;

public class CodeForcesQueen {
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        HashMap<Integer, HashSet<Integer>> tree = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            tree.put(i, new HashSet<>());
        }

        int[] arr = new int[n + 1];
        int root = -1;
        for (int i = 1; i <= n; i++) {
            int pi = fr.nextInt();
            int ci = fr.nextInt();
            arr[i] = ci;
            if(pi != -1) {
                tree.get(pi).add(i);
            }
            if(pi == -1) {
                root = i;
            }
        }

        solve(tree, root, arr, n);
    }

    private static void solve(HashMap<Integer, HashSet<Integer>> tree, int root, int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(arr[i] == 1) {
                HashSet<Integer> children = tree.get(i);
                boolean flag = true;
                for(int child: children) {
                    if(arr[child] == 0) {
                        flag = false;
                        break;
                    }
                }

                if(flag) ans.add(i);
            }
        }

        if(ans.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(ans);
        for(int val: ans) System.out.print(val + " ");
    }
}