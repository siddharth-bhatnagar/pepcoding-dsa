public class Solution {
    public int findRank(String A) {
        int n = A.length();
        long[] fact = new long[52];
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < 52; i++) {
            fact[i] = (fact[i - 1] * i) % 1000003;
        }

        int[] arr = new int[256];
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            arr[(int) ch]++;
        }

        int nol;
        long rank = 0;
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            nol = 0;
            for (int j = 0; j < 256; j++) {
                if (j == (int) ch) {
                    break;
                }

                if (arr[j] == 1) {
                    nol++;
                }
            }
            arr[ch] = 0;
            rank += nol * fact[n - i - 1];
        }
        rank = rank % 1000003;
        rank += 1;
        return (int) rank;
    }
}
