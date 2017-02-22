/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode s;
        int size = 0;
        curr = head;
        for (s = head; s != null; s = s.next) {
            size++;
        }
        return toBST(size);
    }
    
    public TreeNode toBST(int size) {
        if (size <= 0) {
            return null;
        }
        TreeNode left = toBST(size / 2);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = toBST(size - 1 - size / 2);
        
        root.left = left;
        root.right = right;
        return root;
    }
}