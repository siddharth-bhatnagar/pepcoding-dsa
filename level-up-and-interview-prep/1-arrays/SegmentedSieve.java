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



// ------------------------------------------------- Passing on SPOJ below---------------------------------------------//
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main{
 
    
public static void main(String[] args) throws NumberFormatException,IOException{
   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			String []str = br.readLine().split(" ");
			long n = Long.parseLong(str[0]);
			long m = Long.parseLong(str[1]);
		    int k = (int)Math.sqrt(m);
		    boolean []a = new boolean[k+1];
			for(int i=2;i*i<=m;i++){
			    if(a[i]==false){
			        for(int j=i*i;j<=k;j=j+i){
			            a[j] = true;
			        }
			    }
			}
			ArrayList<Integer> prime = new ArrayList<>();
			for(int i=2;i<a.length;i++){
			    if(a[i]==false){
			        prime.add(i);
			    }
			}
// 			System.out.println(prime);
			int span = (int)(m-n);
			boolean []ans = new boolean[span+1];
			for(int i=0;i<prime.size();i++){
			    double p = (double)n/(double)prime.get(i);
			    int start = (int)((Math.ceil(p)) * prime.get(i));
			    
			    if(start == prime.get(i)){
			        start = start + prime.get(i);
			    }
			 //   System.out.println(start);
			    for(int j=start ; j<=m ; j = j+prime.get(i)){
			        ans[(int)(j-n)] = true;
			    }
			 
			 //System.out.println(Math.ceil(p));
			}
			long s = n;
			if(s==(long)1){
			    s=2;
			}
			for(int i=(int)s ; i<=m ; i++){
			    if(ans[(int)(i - n)]==false){
			        System.out.println(i);
			    } 
			}
		}
    }
}