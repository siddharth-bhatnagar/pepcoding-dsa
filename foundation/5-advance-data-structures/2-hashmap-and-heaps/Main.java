import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // one to one mapping, can be used to map between two different types
        // max size of hashmap is the primary mem. i.e. RAM
        HashMap<String, Integer> map = new HashMap<>();
        // <key, vlaue>
        map.put("cse", 600); // O(1) task
        map.put("ece", 515);
        map.put("ee", 615);
        map.put("civil", 100);
        map.put("bio-tech", 50);
        
        System.out.println(map);
        // order of items in map is not the order in which u add them in map.
        // indexing is not possible, ig.

        map.put("cse", 800);
        // old key is overriden.
        System.out.println(map); //O(n)
        // O(1)
        int val = map.get("cse"); // value can be accessed through keys.
        System.out.println(val);

        System.out.println(map.size()); // returns size, O(1)

        System.out.println(map.containsKey("civil")); // returns boolean O(1)

        // map.keyset() has O(1) but due putting keys in AL, operation becomes O(n). 
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        // System.out.println(keys);
        for(String key: keys) {
            int stren = map.get(key);
        }
        // both loops above and below perform the same thing. O(n) task 
        for(String key: map.keySet()){
            int stren = map.get(key);
        }

        
    }
}