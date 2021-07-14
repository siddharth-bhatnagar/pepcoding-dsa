// LintCode 855

public class Solution {
    /**
     * @param words1:
     * @param words2:
     * @param pairs:
     * @return: Whether sentences are similary or not?
     */
    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
        par = new HashMap<>();
        rank = new HashMap<>();
        if (words1.size() != words2.size() || words1 == null || words2 == null)
            return false;

        for (int i = 0; i < words1.size(); i++) {
            par.put(words1.get(i), words1.get(i));
            rank.put(words1.get(i), 1);
            par.put(words2.get(i), words2.get(i));
            rank.put(words2.get(i), 1);
        }

        for (int i = 0; i < pairs.size(); i++) {
            par.put(pairs.get(i).get(0), pairs.get(i).get(0));
            par.put(pairs.get(i).get(1), pairs.get(i).get(1));
            rank.put(pairs.get(i).get(0), 1);
            rank.put(pairs.get(i).get(1), 1);
        }

        for (int i = 0; i < pairs.size(); i++) {
            String w1 = pairs.get(i).get(0);
            String w2 = pairs.get(i).get(1);
            union(w1, w2);
        }

        for (int i = 0; i < words1.size(); i++) {
            String w1 = words1.get(i);
            String w2 = words2.get(i);
            if (find(w1).equals(find(w2)) == false)
                return false;
        }

        return true;
    }

    HashMap<String, String> par;
    HashMap<String, Integer> rank;

    public String find(String str) {
        if (par.get(str).equals(str)) {
            return str;
        }
        String temp = find(par.get(str));
        par.put(str, temp);
        return temp;
    }

    public void union(String one, String two) {
        String l1 = find(one);
        String l2 = find(two);

        if (l1.equals(l2) == false) {
            if (rank.get(l1) > rank.get(l2)) {
                par.put(l2, l1);
            } else if (rank.get(l1) < rank.get(l2)) {
                par.put(l1, l2);
            } else {
                par.put(l1, l2);
                rank.put(l2, rank.get(l2) + 1);
            }
        }
    }
}