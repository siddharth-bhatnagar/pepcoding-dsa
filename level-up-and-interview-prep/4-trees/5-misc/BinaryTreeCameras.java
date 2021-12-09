/**
 * Leetcode 968 Definition for a binary tree node. public class TreeNode { int
 * val; TreeNode left; TreeNode right; TreeNode() {} TreeNode(int val) {
 * this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val
 * = val; this.left = left; this.right = right; } }
 */
class Solution {
    public int minCameraCover(TreeNode root) {
        cameras = 0;
        int code = typeOfNode(root);
        if(code == 0) cameras++;
        return cameras;
    }
    
    private int cameras;
    private int typeOfNode(TreeNode node) {
        if(node == null) return 2;
        
        int left = typeOfNode(node.left);
        int right = typeOfNode(node.right);
        
        if(left == 0 || right == 0) {
            cameras++;
            return 1;
        }
        else if((left == 1 && right == 1) || (left == 1 && right == 2) || (right == 1 && left == 2)) {
            return 2;
        }
        
        return 0;
    }
}


/**
Claim: Every leaf node's parent will have camera installed.
Argument in Favor: If camera is installed at leaf, it will only be able to monitor itself
as well as it's parent. Hence, 2 nodes at max. If camera is installed at leaf's parent, it will 
be able to monitor itself, it's parent and both its children. Hence, 3 nodes minimum and 4 nodes max.

It is optimal to install cameras at leaf nodes' parents. For each node to be able to tell its parent what kind of node it is,
we will assign some code values to different categories. There are three possible categories.

0 -> Leaf Node/Pseudo Leaf Node
1 -> Leaf/Pseudo Leaf Node's Parent Node (Camera will be installed here)
2 -> Any Internal Node without camera but under observation through any of its child or both. 

Pseudo Leaf Nodes are those internal nodes that are not under observation but their subtrees are under observation 
with optimal number of cameras. Hence, they behave as if they were leaves.

Null value will behave as any internal node without camera but under observation. 

Combinations

00 || 01 || 02 -> increase camera count, return 1
11 || 12 -> return 2
22 -> Pseudo Leaf, return 0 

O(N) time, O(H) space

**/