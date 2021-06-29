// Lintcode 892
// Leetcode 269

public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                indegree.put(word.charAt(j), 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            int len = Math.min(curr.length(), next.length());
            int j = 0;
            boolean flag = false;
            while (j < len) {
                if (curr.charAt(j) != next.charAt(j)) {
                    char ch1 = curr.charAt(j);
                    char ch2 = next.charAt(j);

                    if (graph.containsKey(ch1) == false) {
                        HashSet<Character> set = new HashSet<>();
                        set.add(ch2);
                        graph.put(ch1, set);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                    } else {
                        HashSet<Character> set = graph.get(ch1);
                        if (set.contains(ch2) == false) {
                            set.add(ch2);
                            graph.put(ch1, set);
                            indegree.put(ch2, indegree.get(ch2) + 1);
                        }
                    }
                    flag = true;
                    break;
                }
                j++;

            }
            if (flag == false && curr.length() > next.length()) {
                return "";
            }
        }

        LinkedList<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.addLast(ch);
            }
        }

        int count = 0;
        while (queue.size() > 0) {
            char rem = queue.removeFirst();
            ans.append(rem);
            count++;

            if (graph.containsKey(rem) == true) {
                HashSet<Character> nbrs = graph.get(rem);
                for (char nbr : nbrs) {
                    indegree.put(nbr, indegree.get(nbr) - 1);
                    if (indegree.get(nbr) == 0) {
                        queue.addLast(nbr);
                    }
                }
            }
        }

        if (count == indegree.size()) {
            return ans.toString();
        } else {
            return "";
        }
    }
}