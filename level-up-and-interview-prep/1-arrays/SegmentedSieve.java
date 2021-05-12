import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        
        while(t-- > 0) {
            int L = scn.nextInt();
            int R = scn.nextInt();
            ArrayList<Integer> primes = segmentedSieve(L, R);
            for(int i=0;i<primes.size();i++) {
                System.out.println(primes.get(i));
            }
            System.out.println();
        }

        scn.close();
    }

    public static ArrayList<Integer> segmentedSieve(int L, int R) {
        ArrayList<Integer> primes = new ArrayList<>();
        int N = (int) Math.sqrt(R) + 1;
        ArrayList<Integer> primesTillN = sieveOfEratosthenes(N);

        boolean[] numbers = new boolean[R-L+1];
        if(L==1) numbers[0] = true;
        for(int i=0;i<primesTillN.size();i++) {
            int p = primesTillN.get(i);
            int fm = ((L/p)+1)*p;

            if(fm < L) fm += p;
            if(fm == p) fm += p;
            
            for(int j=fm;j<=R;j+=p) {
                numbers[j-L] = true;
            }
        }


        for(int i=L;i<=R;i++) {
            if(!numbers[i-L]) primes.add(i);
        }

        return primes;
    }
    public static ArrayList<Integer> sieveOfEratosthenes(int N) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] primes = new boolean[N+1];
        // false - prime, true - composite

        for(int i=2;i*i<=N;i++) {
            if(!primes[i]) {
                for(int j=i*i;j<=N;j+=i) {
                    primes[j] = true;
                }
            }
        }

        for(int i=2;i<=N;i++) {
            if(!primes[i]) result.add(i);
        }
        return result;
    }
}