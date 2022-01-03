/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
// Leetcode
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        p = head;
        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            curr = curr.next;
            count++;
        }
        
        TreeNode root = solve(count);
        return root;
    }
    
    private ListNode p;
    private TreeNode solve(int n) {
        if(n == 0) return null;
        
        TreeNode left = solve(n/2);
        TreeNode node = new TreeNode(p.val);
        p = p.next;
        node.left = left;
        node.right = solve(n - n/2 - 1);
        
        return node;
    }
}