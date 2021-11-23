// Leetcode 987
// Complexity: O(nlogn)
// Constraint - All nodes at the same vertical level and same horizontal level should be sorted in asc order
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        int hl = 0;
        Pair rp = new Pair(root, 0);
        q.add(rp);
        int min = 0, max = 0;
        while(q.size()>0) {
            int size = q.size();
            
            while(size-- > 0) {
                Pair rem = q.remove();
                TreeNode node = rem.node;
                int vl = rem.level;
                
                min = Math.min(vl, min);
                max = Math.max(vl, max);
                
                if(!map.containsKey(vl)) {
                    map.put(vl, new ArrayList<>());
                }
                
                map.get(vl).add(new Pair(node, hl));
                
                if(node.left!=null) {
                    q.add(new Pair(node.left, vl - 1));
                }
                
                if(node.right!=null) {
                    q.add(new Pair(node.right, vl+1));
                }
            }
            hl++;
        }
        
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=min;i<=max;i++) {
            ArrayList<Pair> temp = map.get(i);
            Collections.sort(temp);
            ans.add(new ArrayList<>());
            for(int k=0;k<temp.size();k++) {
                ans.get(i-min).add(temp.get(k).node.val);
            }
        }
        
        return ans;
    }
    
    public class Pair implements Comparable<Pair> {
        TreeNode node;
        int level;
        
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
        
        @Override
        public int compareTo(Pair o) {
            if(this.level != o.level) {
                return this.level - o.level;
            }else {
                return this.node.val - o.node.val;
            }
        }
    }
}