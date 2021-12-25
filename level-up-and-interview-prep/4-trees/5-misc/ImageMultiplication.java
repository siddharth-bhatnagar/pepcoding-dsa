class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> tree = constructTree(n, edges);
        
        int[] count = new int[n];
        int[] sumOfDistances = new int[n];
        
        int root = 0;
        
        countNodesInSubtree(tree, root, new boolean[n], count);
        calculateDistancesFromNode(tree, root, new boolean[n], sumOfDistances);
        calculateResult(tree, root, new boolean[n], n, count, sumOfDistances);
        
        return sumOfDistances;
    }
    
    private List<List<Integer>> constructTree(int n, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++) tree.add(new ArrayList<>());
        
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        return tree;
    }
    
    private int countNodesInSubtree(List<List<Integer>> tree, int node, boolean[] visited, int[] count) {
        visited[node] = true;
        count[node] = 1;
        for(int child: tree.get(node)) {
            if(!visited[child]) {
                count[node] += countNodesInSubtree(tree, child, visited, count);
            }
        }
        
        return count[node];
    }
    
    private void calculateDistancesFromNode(List<List<Integer>> tree, int node, boolean[] visited, int[] result) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;
        int level = 0;
        
        while(queue.size() > 0) {
            int size = queue.size();
            while(size-- > 0) {
                int rem = queue.remove();
                result[node] += level;
                
                for(int child: tree.get(rem)) {
                    if(!visited[child]) {
                        queue.add(child);
                        visited[child] = true;
                    }
                }
            }
            level++;
        }  
    }
    
    private void calculateResult(List<List<Integer>> tree, int node, boolean[] visited, int n, int[] count, int[] result) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(node);
        visited[node] = true;
        
        while(queue.size() > 0) {
            int size = queue.size();
            while(size-- > 0) {
                int rem = queue.removeFirst();
                
                for(int child: tree.get(rem)) {
                    if(!visited[child]) {
                        queue.addLast(child);
                        result[child] = result[rem] - count[child] + (n - count[child]);
                        visited[child] = true;
                    }
                }
            }
        }
    }
}





















