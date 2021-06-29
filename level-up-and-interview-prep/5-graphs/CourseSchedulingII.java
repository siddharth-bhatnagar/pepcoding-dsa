// Leetcode 210
// Kahn's Algorithm 
// O(V+E)

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int ai = prerequisites[i][0];
            int bi = prerequisites[i][1];

            graph.get(bi).add(ai);
            indegree[ai]++;
        }

        LinkedList<Integer> que = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                que.addLast(i);
            }
        }

        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (que.size() > 0) {
            int rem = que.removeFirst();
            ans.add(rem);
            count++;

            for (int nbr : graph.get(rem)) {
                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    que.addLast(nbr);
                }
            }
        }
        int res[] = new int[ans.size()];
        if (count == numCourses) {
            for (int i = 0; i < ans.size(); i++) {
                res[i] = ans.get(i);
            }
            return res;
        } else {
            return new int[0];
        }

    }
}