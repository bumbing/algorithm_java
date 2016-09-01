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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)  return null;
        ListNode mid = findMid(head);
        if(mid.next==null)  return new TreeNode(mid.val);//This is the tricky part
        ListNode rt = mid.next;
        mid.next = null;
        TreeNode root = new TreeNode(rt.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rt.next);
        return root;
    }
    
    public ListNode findMid(ListNode head){
        ListNode pre = head, p1 = head, p2 = head;
        while(p2!=null && p2.next!=null){ //Is p2.next!=null && p2.next.next!=null also working?
            p2 = p2.next.next;
            pre = p1;
            p1 = p1.next;
        }
        return pre;
    }
}