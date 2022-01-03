/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode getAllElements(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return root1 == null ? root2 : root1;

        TreeNode t1 = flattenToCDLL(root1);
        TreeNode t2 = flattenToCDLL(root2);
        
        TreeNode head = mergeTwoCDLL(t1, t2);
        curr = head;
        int size = 0;
        while(head != null) {
            size++;
            head = head.right;
        }
        return buildTree(size);
    }
    
    private TreeNode flattenToCDLL(TreeNode node) {
        if (node == null) return null;

        TreeNode lt = flattenToCDLL(node.left);
        TreeNode rt = flattenToCDLL(node.right);

        node.left = node;
        node.right = node;

        if (lt == null && rt == null) {
            return node;
        } else if (lt == null) {
            TreeNode t = add(node, rt);
            return t;
        } else if (rt == null) {
            TreeNode t = add(lt, node);
            return t;
        } else {
            TreeNode t1 = add(lt, node);
            TreeNode t2 = add(t1, rt);
            return t2;
        }
    }
    
    private TreeNode add(TreeNode t1, TreeNode t2) {
        TreeNode h1 = t1.right;
        TreeNode h2 = t2.right;
        t1.right = h2;
        h2.left = t1;
        h1.left = t2;
        t2.right = h1;
        return t2;
    }
    
    private TreeNode mergeTwoCDLL(TreeNode t1, TreeNode t2) {
        TreeNode h1 = t1.right;
        t1.right = null;
        h1.left = null;
        TreeNode h2 = t2.right;
        t2.right = null;
        h2.left = null;

        TreeNode c1 = h1, c2 = h2;
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        TreeNode prev = dummy;

        while(c1 != null && c2 != null) {
            if(c1.val < c2.val) {
                prev.right = c1;
                c1 = c1.right;
            }
            else if(c1.val > c2.val) {
                prev.right = c2;
                c2 = c2.right;
            }
            else {
                prev.right = c1;
                c1 = c1.right;
                c2 = c2.right;
            }

            prev = prev.right;
        }

        prev.right = c1 != null ? c1 : c2;
        return dummy.right;
    }

    private TreeNode curr;
    private TreeNode buildTree(int size) {
        if(size == 0) return null;
        TreeNode left = buildTree(size/2);
        TreeNode node = curr;
        curr = curr.right;
        node.left = left;
        node.right = buildTree(size - size/2 - 1);

        return node;
    }
}


/**

Approach: 

1) Flatten both BST to circular doubly linked lists in inorder so that both lists are sorted. O(M + N) time, O(log M + Log N) space
2) Merge two sorted Lists without duplicates. O(M + N) time, O(1) space
3) Calculate size of the merged sorted list. O(M+N) time, O(1) space
4) Try to place each node using size/structure approach. O(M+N) time, O(log(M+N)) space 


Overall: O(4*(M+N)) time, O(logM + logN + log(M+N)) space
 */





