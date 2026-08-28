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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        if (n == 1 && head.next == null) {
            return head.next;
        }
        int size = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            size+=2;
        }
        // handle odd length
        if (fast != null && fast.next == null) {
            size++;
        }

        ListNode node = head;
        int count = size - n;
        ListNode prev = null;

        while (count > 0) {
            prev = node;
            node = node.next;
            count--;
        }

        // remove the node
        if (prev == null) {
            // removing head
            head = head.next;
        } else {
            // removing any node except head
            prev.next = node.next;
            node = null;
        }
        

        return head;
    }
}
