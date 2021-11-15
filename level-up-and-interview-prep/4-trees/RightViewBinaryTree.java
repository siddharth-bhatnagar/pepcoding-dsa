// Level order -- last node of each level
// Leetcode 199

// BFS Solution
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rsv = new ArrayList<>();
        
        if(root == null) return rsv;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
     
        while(queue.size() > 0) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.removeFirst();
                if(node.left != null) {
                    queue.addLast(node.left);
                }
                
                if(node.right != null) {
                    queue.addLast(node.right);
                }
                
                if(size == 0) {
                    rsv.add(node.val);
                }
            }
        }
        
        return rsv;
    }
}


// DFS Solution
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rsv = new ArrayList<>();
        rightView(root, rsv, 0);
        return rsv;
    }
    
    private void rightView(TreeNode curr, List<Integer> rsv, int currDepth) {
        if(curr == null) return;
        
        if(currDepth == rsv.size()) rsv.add(curr.val);
        
        rightView(curr.right, rsv, currDepth+1);
        rightView(curr.left, rsv, currDepth+1);
    }
}