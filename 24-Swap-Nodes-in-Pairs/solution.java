/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        head = root;
        while(head.next!=null && head.next.next!=null){
            ListNode temp = head.next.next;
            head.next.next = head.next.next.next;
            temp.next = head.next;
            head.next = temp;
            head = head.next.next;
        }
        return root.next;
    }
}