// Leetcode 990
// Satisfiability of equality equations

class Solution {
    public boolean equationsPossible(String[] equations) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        int n = equations.length;

        for (int i = 0; i < n; i++) {
            char c1 = equations[i].charAt(0);
            char c2 = equations[i].charAt(3);

            parent.put(c1, c1);
            parent.put(c2, c2);

            rank.put(c1, 1);
            rank.put(c2, 2);
        }

        for (int i = 0; i < n; i++) {
            char c1 = equations[i].charAt(0);
            char c2 = equations[i].charAt(3);
            char sign = equations[i].charAt(1);

            if (sign == '=') {
                union(c1, c2);
            }
        }

        for (int i = 0; i < n; i++) {
            char c1 = equations[i].charAt(0);
            char c2 = equations[i].charAt(3);
            char sign = equations[i].charAt(1);

            if (sign == '!') {
                if (find(c1) == find(c2))
                    return false;
            }
        }

        return true;
    }

    HashMap<Character, Character> parent;
    HashMap<Character, Integer> rank;

    public char find(char ch) {
        if (parent.get(ch) == ch) {
            return ch;
        }
        char temp = find(parent.get(ch));
        parent.put(ch, temp);
        return temp;
    }

    public void union(char c1, char c2) {
        char lc1 = find(c1);
        char lc2 = find(c2);

        if (lc1 != lc2) {
            if (rank.get(lc1) < rank.get(lc2)) {
                parent.put(lc1, lc2);
            } else if (rank.get(lc1) > rank.get(lc2)) {
                parent.put(lc2, lc1);
            } else {
                parent.put(lc2, lc1);
                rank.put(lc1, rank.get(lc1) + 1);
            }
        }
    }
}
