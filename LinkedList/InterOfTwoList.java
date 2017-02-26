/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // HashMap<ListNode, Integer> hashtable = new HashMap<>();
        // while (headA != null) {
        //     hashtable.put(headA, headA.val);
        //     headA = headA.next;
        // }
        // while (headB != null) {
        //     if (hashtable.containsKey(headB)) {
        //         return headB;
        //     }
        //     headB = headB.next;
        // }
        // return headB;
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (headA != headB) {
            if (headA == null) {
                headA = b;
            } else {
                headA = headA.next;
            }
            
            if (headB == null) {
                headB = a;
            } else {
                headB = headB.next;
            }
        }
        return headA;
    }
}