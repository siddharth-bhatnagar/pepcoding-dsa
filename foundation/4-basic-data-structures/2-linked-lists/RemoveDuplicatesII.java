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

// Leetcode 82
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode node = new ListNode(-500);
        node.next = head;
        ListNode curr = head.next;
        
        while(curr != null) { 
            boolean isLoopRun = false;
            while(curr != null && node.next.val == curr.val) {
                isLoopRun = true;
                curr = curr.next;
            }
            
            if(isLoopRun == true) {
                node.next = curr;
            }
            else {
                node = node.next;
            }
            
            if(curr != null) {
                curr = curr.next;
            }
            
            if(node.val == -500) head = node.next;
        }
        
        return head;
    }
}