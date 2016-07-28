/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root, next = null, previous = null;
        while(cur!=null || next!=null){
            if(cur==null){
                cur = next;
                next = null;
                previous = null;
            }else{
                if(cur.left!=null || cur.right!=null){
                    if(cur.left!=null && cur.right!=null)   cur.left.next = cur.right;
                    if(previous!=null)  previous.next = (cur.left==null)?cur.right:cur.left;
                    previous = (cur.right==null)?cur.left:cur.right;
                    if(next==null)  next = (cur.left==null)?cur.right:cur.left;
                }
                cur = cur.next;
            }
        }
        return;
    }
}