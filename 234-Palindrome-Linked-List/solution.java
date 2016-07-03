/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)    return true;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode head1 = root, head2 = root;
        while(head1 != null && head1.next != null){
            head1 = head1.next.next;
            head2 = head2.next;
        }
        
        head2 = reverse(head2.next);
        head1 = root.next;
        
        while(head2 != null){
            if(head1.val != head2.val)  return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head){
        //要让第一个点的next指向null，否则死循环
        ListNode head1 = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = head1;
            head1 = head;
            head = tmp;
        }
        return head1;
    }
}