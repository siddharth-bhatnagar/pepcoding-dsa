// Bottom view
// Using BFS

// If last node in same hl and vl needed, then add left child, then right child
// If first one needed instead, then add right child first and then left child.
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root, 0));
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(queue.size() > 0) {
            int size = queue.size();
            while(size-- > 0) {
                Pair rem = queue.removeFirst();
                
                map.put(rem.vl, rem.node.data);
                min = Math.min(min, rem.vl);
                max = Math.max(max, rem.vl);
                
                // Adding children, collision case handled
                if(rem.node.left != null) {
                    queue.addLast(new Pair(rem.node.left, rem.vl-1));
                }
                
                if(rem.node.right != null) {
                    queue.addLast(new Pair(rem.node.right, rem.vl+1));
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=min;i<=max;i++) {
            ans.add(map.get(i));
        }
        
        return ans;
    }
    
    private class Pair {
        Node node;
        int vl;
        
        public Pair(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }
}