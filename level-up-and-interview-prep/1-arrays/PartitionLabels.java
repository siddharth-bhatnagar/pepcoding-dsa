// Leetcode 763

class Solution {
    public List<Integer> partitionLabels(String S) {
        int n = S.length();
        int last[] = new int[26];
        for (int i = 0; i < n; i++) {
            int idx = S.charAt(i) - 'a';
            last[idx] = i;
        }
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, pos = 0;
        while (j < n) {
            int idx = S.charAt(j) - 'a';
            pos = Math.max(pos, last[idx]);
            if (pos == j) {
                list.add(j - i + 1);
                i = j + 1;
            }
            j++;
        }
        return list;
    }
}

// O(n) time, O(1) space