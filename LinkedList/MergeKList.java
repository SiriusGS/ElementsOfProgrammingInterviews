/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
     // k路归并算法，外排序
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
         // version 1 . merge two lists at a time

    // public ListNode mergeKLists(List<ListNode> lists) {  
        
    //     if (lists == null || lists.size() == 0) {
    //         return null;
    //     } 
    //     while (lists.size() > 1) {
    //         List<ListNode> list = new ArrayList<>();
    //         for (int i = 0; i + 1 < lists.size(); i += 2) {
    //             ListNode merge_list = merge(lists.get(i), lists.get(i + 1));
    //             list.add(merge_list);
    //         }
    //         if (lists.size() % 2 != 0) {
    //             list.add(lists.get(lists.size() - 1));
    //         }
    //         lists = list;
    //     }
    //     return lists.get(0);
    // }
    
    // version 2 divide and conquer
    
    // public ListNode mergeKLists(List<ListNode> lists) {  
    //       if (lists == null || lists.size() == 0) {
    //           return null;
    //       }
    //       return helper(0, lists.size() - 1, lists);
    // }
    
    // private ListNode helper(int start, int end, List<ListNode> lists) {
    //     if (start == end) {
    //         return lists.get(start);
    //     }
    //     int mid = start + (end - start) / 2;
    //     ListNode left = helper(start, mid, lists);
    //     ListNode right = helper(mid + 1, end, lists);
    //     return merge(left, right);
    // }
    
    //version 3 heap
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        
        return dummy.next;
    }
}
