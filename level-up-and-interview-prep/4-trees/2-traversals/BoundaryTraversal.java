// Leetcode 545, Lintcode 878, GFG
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return new ArrayList<>();

        boundaryNodes = new ArrayList<>();
        visitedNodes = new HashSet<>();
        
        boundaryNodes.add(root.val);
        visitedNodes.add(root);

        leftBoundary(root.left);
        leaves(root);
        rightBoundary(root.right);

        return boundaryNodes;
    }

    HashSet<TreeNode> visitedNodes;
    List<Integer> boundaryNodes;

    private void leftBoundary(TreeNode node) {
        if(node == null) return;
        if(visitedNodes.contains(node) == false) {
            boundaryNodes.add(node.val);
            visitedNodes.add(node);
        }
        if(node.left != null) {
            leftBoundary(node.left);
        }
        else if(node.right != null) {
            leftBoundary(node.right);
        }
    }

    private void leaves(TreeNode node) {
        if(node == null) return;

        if(node.left == null && node.right == null && visitedNodes.contains(node)==false) {
            boundaryNodes.add(node.val);
            visitedNodes.add(node);
        }

        leaves(node.left);
        leaves(node.right);
    }

    private void rightBoundary(TreeNode node) {
        if(node == null) return;
        if(node.right != null) {
            rightBoundary(node.right);
        }
        else if(node.left != null) {
            rightBoundary(node.left);
        }

        if(visitedNodes.contains(node) == false) {
            boundaryNodes.add(node.val);
            visitedNodes.add(node);
        }
    }
}

// O(N), O(H)