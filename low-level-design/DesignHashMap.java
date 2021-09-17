import java.util.LinkedList;
import java.io.*;

public class DesignHashMap {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}

public class HashMap<K, V> {
    
    private class HashNode {
        K key;
        V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private LinkedList<HashNode>[] buckets;

    public HashMap() {
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int bi = 0; bi < buckets.length; bi++) {
            buckets[bi] = new LinkedList<>();
        }
    }

    private int getIndexInBucket(K key, int bi) {
        for (int ni = 0; ni < buckets[bi].size(); ni++) {
            if (buckets[bi].get(ni).key.equals(key)) {
                return ni;
            }
        }
        return -1;
    }

    private int hashFn(K key) {
        int bi = key.hashCode();
        return Math.abs(bi) % buckets.length;
    }

    private void rehash() throws Exception {
        LinkedList<HashNode>[] oldBuckets = buckets;
        initbuckets(oldBuckets.length * 2);
        size = 0;
        for (int i = 0; i < oldBuckets.length; i++) {
            for (HashNode node : oldBuckets[i]) {
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) throws Exception {
        int bi = hashFn(key);
        int ni = getIndexInBucket(key, bi);

        if (ni != -1) {
            buckets[bi].get(ni).value = value;
        } else {
            HashNode node = new HashNode(key, value);
            buckets[bi].addLast(node);
            size++;
        }

        double lambda = size * 1.0 / buckets.length;
        if (lambda > 2.0) {
            rehash();
        }
    }

    public V get(K key) throws Exception {
        int bi = hashFn(key);
        int ni = getIndexInBucket(key, bi);

        if (ni != -1) {
            return buckets[bi].get(ni).value;
        } else {
            return null;
        }
    }

    public boolean containsKey(K key) {
        int bi = hashFn(key);
        int ni = getIndexInBucket(key, bi);

        if (ni != -1) {
            return true;
        } else {
            return false;
        }
    }

    public V remove(K key) throws Exception {
        int bi = hashFn(key);
        int ni = getIndexInBucket(key, bi);

        if (ni != -1) {
            size--;
            return buckets[bi].remove(ni).value;
        } else {
            return null;
        }
    }

    public ArrayList<K> keyset() throws Exception {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            for (HashNode node : buckets[i]) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public int size() {
        return size;
    }

    public void display() {
        System.out.println("Display Begins");
        for (int bi = 0; bi < buckets.length; bi++) {
            System.out.print("Bucket" + bi + " ");
            for (HashNode node : buckets[bi]) {
                System.out.print(node.key + "@" + node.value + " ");
            }
            System.out.println(".");
        }
        System.out.println("Display Ends");
    }
}