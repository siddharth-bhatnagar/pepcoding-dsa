import java.util.*;
import java.io.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int[] nums = new int[scn.nextInt()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (map.containsKey(num) == false) {
                int sp = num;
                int ep = num;

                if (map.containsKey(num - 1) == true) {
                    sp = sp - map.get(num - 1);
                }

                if (map.containsKey(num + 1) == true) {
                    ep = ep + map.get(num + 1);
                }

                int newlen = ep - sp + 1;
                map.put(sp, newlen);
                map.put(ep, newlen);

                if (sp != num && ep != num) {
                    map.put(num, 1);
                }

                max = Math.max(max, newlen);
            }
        }
        System.out.println(max);
    }
}
