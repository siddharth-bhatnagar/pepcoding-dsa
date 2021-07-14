// Leetcode 684
// O(V+E)
// DSU
class Solution {

        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        cyclicEdges = new ArrayList<>();
        
        for(int i=1;i<parent.length;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i=0;i<edges.length;i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            
            union(x, y);
        }
        
        Integer[] temp = cyclicEdges.get(cyclicEdges.size()-1);
        int[] pair = new int[2];
        pair[0] = temp[0];
        pair[1] = temp[1];
        return pair;
    }
    
    int[] parent;
    int[] rank;
    ArrayList<Integer[]> cyclicEdges;
    
    public int find(int x) {
        if(parent[x] == x) return x;
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    public void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);
        
        if(lx!=ly) {
            if(rank[lx] < rank[ly]) {
                parent[lx] = ly;
            }
            else if(rank[lx] > rank[ly]) {
                parent[ly] = lx;
            }
            else {
                parent[ly] = lx;
                rank[lx]++;
            }
        }
        else{
            Integer[] pair = new Integer[2];
            pair[0] = x;
            pair[1] = y;
            
            cyclicEdges.add(pair);
        }
    }
}