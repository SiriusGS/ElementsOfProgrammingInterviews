/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
     // version 1
    // public RandomListNode copyRandomList(RandomListNode head) {
    //     // write your code here
    //     if (head == null) {
    //         return null;
    //     }
    //     HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    //     RandomListNode dummy = new RandomListNode(0);
    //     RandomListNode pre = dummy, newNode;
        
    //     while (head != null) {
    //         if (map.containsKey(head)) {
    //             newNode = map.get(head);
    //         } else {
    //             newNode = new RandomListNode(head.label);
    //             map.put(head, newNode);
    //         }
    //         pre.next = newNode;
    //         if (head.random != null) {
    //             if (map.containsKey(head.random)) {
    //                 newNode.random = map.get(head.random);
    //             } else {
    //                 newNode.random = new RandomListNode(head.random.label);
    //                 map.put(head.random, newNode.random);
    //             }
    //         }
    //         pre = newNode;
    //         head = head.next;
    //     }
    //     return dummy.next;
        
    // }
    //version 2
    // public RandomListNode copyRandomList(RandomListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     RandomListNode prev = new RandomListNode(0);
    //     HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    //     RandomListNode temp = head;
    //     RandomListNode result = head;
    //     while (head != null) {
    //         RandomListNode newNode = new RandomListNode(head.label);
    //         map.put(head, newNode);
    //         prev.next = newNode;
    //         prev = newNode;
    //         head = head.next;
    //     }
    
    //     while (temp != null) {
    //         map.get(temp).random = map.get(temp.random); 
    //         temp = temp.next;
    //     }
    //     return map.get(result);
        
    // }
    
    // version3 
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }   
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newhead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            head = head.next;
        }
        return newhead;
    }
}