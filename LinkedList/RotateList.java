/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head, curr = head, temp = dummy;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return dummy.next;
        }
        for (int i = length - k; i > 0; i--) {
            temp = temp.next;
        }
        
        dummy.next = temp.next;
        temp.next = null;
        tail.next = head;

        
        return dummy.next;
     }
}