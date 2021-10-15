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

//  Leetcode 148
// O(NLog N)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = getMidNode(head);
        ListNode midp1 = mid.next;
        mid.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(midp1);
        
        ListNode sortedListsMergedHead = mergeTwoSortedList(l1, l2);
        
        return sortedListsMergedHead;
    }
    
    private ListNode getMidNode(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
        
        ListNode node = new ListNode(-1);
        ListNode prev = node;
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        while(c1 != null && c2 != null) {
            if(c1.val < c2.val) {
                prev.next = c1;
                c1 = c1.next;
            }
            else {
                prev.next = c2;
                c2 = c2.next;
            }
            
            prev = prev.next;
        }
        
        prev.next = c1 != null ? c1 : c2;
        
        return node.next;
    }
}