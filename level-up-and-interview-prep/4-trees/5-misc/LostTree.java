import java.io.*;
import java.util.*;

public class LostTree {

    public static void main(String... args) {
        FastReader fr = new FastReader();

        // Taking user input: Number of nodes
        int n = fr.nextInt();
        // Will store edge between two nodes in Adjacency Matrix
        int[][] map = new int[n + 1][n + 1];

        // Assuming Root node as 1 and querying for its edges
        System.out.println("? " + 1);
        // This array will tell us the distance from other nodes in terms of edges
        // Indexing is 1 - based;
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = fr.nextInt();
        // Flushing console after successful query
        System.out.flush();

        // Count of nodes on odd level and even levels
        int even = 1, odd = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 1) {
                map[1][i] = 1;
                map[i][1] = 1;
            }
            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        // If odd is equal to or less than even, then check == 1 
        // Because we have already used 1 query of even level, that is ?1, so that it does not hit the ceil(n/2) limit
        int check = -1;
        if (even <= odd) {
            check = 0;
        } else {
            check = 1;
        }

        for(int i=2;i<=n;i++) {
            if(arr[i] % 2 == check) {
                System.out.println("? " + i);
                
                int[] arr1 = new int[n+1];
                for(int j=1;j<=n;j++) arr1[j] = fr.nextInt();
                System.out.flush();

                for(int j=1;j<=n;j++) {
                    if(arr1[j] == 1) {
                        map[j][i] = 1;
                        map[i][j] = 1;
                    }
                }
            }
        }
        System.out.println("!");
        for(int i=1;i<=n;i++) {
            for(int j=1;j<i;j++) {
                if(map[i][j] == 1) {
                    System.out.println(i + " " + j);
                }
            }
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
