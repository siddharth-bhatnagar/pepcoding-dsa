/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Leetcode 449
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = serialize(root, new StringBuilder(""));
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    
    private StringBuilder serialize(TreeNode node, StringBuilder sb) {
        if(node == null) return sb;
        
        serialize(node.left, sb);
        serialize(node.right, sb);
        sb.append(node.val + " ");
        
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        
        LinkedList<Integer> rpost = new LinkedList<>();
        
        for(String s: data.split(" ")) {
            rpost.addFirst(Integer.valueOf(s));
        }
        
        return buildTree(rpost, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode buildTree(LinkedList<Integer> rpost, int min, int max) {
        if(rpost.size() <= 0) return null;
        
        int val = rpost.peekFirst();
        
        if(val >= min && val <=max) {
            TreeNode node = new TreeNode(val);
            rpost.removeFirst();
            
            node.right = buildTree(rpost, val+1, max);
            node.left = buildTree(rpost, min, val-1);
            
            return node;
        }
        
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;