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

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == null || head.next == null) {
            return;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = null;
        // reverse list from slow.next to fast
        ListNode r = reverseList(slow.next);
        slow.next = null;
        
        ListNode l1 = head;
        ListNode l2 = r;
        while (l2 != null) {
            System.out.println(l1.val + " &larr; " + l2.val);
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;            
        }            
    }

    private ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode curr = node;
        ListNode next = node.next;
        node.next = null;
        curr.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }
        return curr;
    }
}
