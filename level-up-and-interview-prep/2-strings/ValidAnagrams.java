// Leetcode 242


// Sorting: O(NlogN) time, O(1) or O(n) space
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}

// 26 size int arr: O(N) time, O(1) space
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

// HashTable O(N) time, O(1) space
// Works with Unicode Characters 
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            fmap.put(s.charAt(i), fmap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (fmap.containsKey(ch) == false)
                return false;
            if (fmap.get(ch) == 1) {
                fmap.remove(ch);
            } else {
                fmap.put(ch, fmap.get(ch) - 1);
            }
        }

        return fmap.size() == 0;
    }
}