// Top View 

// Using BFS
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root, 0));
        
        HashMap<Integer, Integer> nodes = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while(queue.size() > 0) {
            int size = queue.size();
            while(size-- > 0) {
                Pair p = queue.removeFirst();
                if(!nodes.containsKey(p.vl)) {
                    nodes.put(p.vl, p.node.data);
                    min = Math.min(min, p.vl);
                    max = Math.max(max, p.vl);
                }
                
                if(p.node.left!=null) {
                    queue.addLast(new Pair(p.node.left, p.vl-1));
                }
                
                if(p.node.right!=null) {
                    queue.addLast(new Pair(p.node.right, p.vl+1));
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=min;i<=max;i++) {
            ans.add(nodes.get(i));
        }
        
        return ans;
    }
    
    static class Pair {
        Node node;
        int vl;
        
        public Pair(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }
}