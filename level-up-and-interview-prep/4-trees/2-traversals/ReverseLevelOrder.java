// Leetcode 107


// ArrayList<ArrayList<Integer>> approach
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            ans.add(list);
        }

        Collections.reverse(ans);

        return ans;
    }
}


// GFG
// Smart processing, adding nodes in queue from right to left
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        if (node == null)
            return new ArrayList<>();

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        ArrayList<Integer> ans = new ArrayList<>();
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                node = queue.removeFirst();
                ans.add(node.data);
                
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                
                if (node.left != null) {
                    queue.addLast(node.left);
                }
            }
        }

        Collections.reverse(ans);

        return ans;
    }
} 


