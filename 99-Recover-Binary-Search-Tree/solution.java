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
    public void recoverTree(TreeNode root) {
        TreeNode pre=null, head=null, tail=null;
        TreeNode cur = root;
        if(root == null)    return;
        Stack<TreeNode> stack = new Stack();
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(pre!= null && pre.val>temp.val){
                if(head==null){
                    head = pre; 
                    tail = temp;
                }else{
                    tail = temp;
                    break;
                }
            }
            pre = temp;
            temp = temp.right;
            while(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
        }
        int num = head.val;
        head.val = tail.val;
        tail.val = num;
        return;
        
    }
}