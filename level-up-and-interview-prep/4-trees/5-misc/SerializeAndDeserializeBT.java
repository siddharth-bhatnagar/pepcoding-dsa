/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Leetcode 297
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialized = new StringBuilder();
        rserialize(root);
        serialized.deleteCharAt(serialized.length() - 1);
        return serialized.toString();
    }
    
    private StringBuilder serialized;
    private void rserialize(TreeNode root) {
        if(root == null) {
            serialized.append("null ");
            return;
        }
        serialized.append(root.val + " ");
        rserialize(root.left);
        rserialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        i = 0;
        String[] arr = data.split(" ");
        return helper(arr);
    }
    
    private int i;
    private TreeNode helper(String[] arr) {
        if(arr[i].equals("null")) {
            i++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        node.left = helper(arr);
        node.right = helper(arr);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = serialize(root, new StringBuilder(""));
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    
    private StringBuilder serialize(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("1111 ");
            return sb;
        }
        
        sb.append(node.val + " ");
        serialize(node.left, sb);
        serialize(node.right, sb);
        
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        
        LinkedList<Integer> pre = new LinkedList<>();
        for(String s: data.split(" ")) {
            pre.addLast(Integer.parseInt(s));
        }
        
        return buildTree(pre);
    }
    
    private TreeNode buildTree(LinkedList<Integer> pre) {
        if(pre.size() <= 0) return null;
        if(pre.peekFirst() == 1111) {
            pre.removeFirst();
            return null;
        }
        
        TreeNode node = new TreeNode(pre.removeFirst());
        node.left = buildTree(pre);
        node.right = buildTree(pre);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));