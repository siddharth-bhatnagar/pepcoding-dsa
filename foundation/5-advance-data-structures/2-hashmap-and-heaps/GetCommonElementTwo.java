import java.io.*;
import java.util.*;

public class GetCommonElementTwo {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int[] a1 = new int[scn.nextInt()];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = scn.nextInt();
        }

        int[] a2 = new int[scn.nextInt()];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a1.length; i++) {
            int num = a1[i];
            if (map.containsKey(num) == true) {
                int val = map.get(num);
                val++;
                map.put(num, val);
            } else {
                map.put(num, 1);
            }
        }

        for (int i = 0; i < a2.length; i++) {
            int num = a2[i];
            if (map.containsKey(num)) {
                int val = map.get(num);
                if (val > 0)
                    System.out.println(num);
                val--;
                map.put(num, val);
            }
        }
    }

}