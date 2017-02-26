/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 找到中点， reverse 后半部分， merge；
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, firstHalf = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow.next);
        slow.next = null;
        ListNode curr =  new ListNode(0);
        while (firstHalf != null && secondHalf != null) {
            curr.next = firstHalf;
            firstHalf = firstHalf.next;
            curr = curr.next;
            curr.next = secondHalf;
            secondHalf = secondHalf.next;
            curr = curr.next;
        }
        curr.next = firstHalf != null ? firstHalf : secondHalf;
        
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}