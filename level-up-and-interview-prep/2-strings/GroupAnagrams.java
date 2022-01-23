// Leetcode 49
// O(NK) time, O(NK) space

class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        if (arr.length == 0)
            return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : arr) {
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                counter[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int val : counter) {
                sb.append("$");
                sb.append(val);
            }

            String key = sb.toString();
            if (map.containsKey(key) == false) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}