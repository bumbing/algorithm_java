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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)    return true;
        Stack<TreeNode> left = new Stack(), right = new Stack();
        TreeNode l = root.left, r = root.right;
        while(l!=null || r!=null){
            if(l==null || r==null)  return false;
            left.push(l);
            right.push(r);
            l = l.left;
            r = r.right;
        }
        
        while(!left.isEmpty() || !right.isEmpty()){
            if(left.isEmpty() && right.isEmpty())   return false;
            l = left.pop();
            r = right.pop();
            if(l.val != r.val)  return false;
            l = l.right;
            r = r.left;
            while(l!=null || r!=null){
                if(l==null || r==null)  return false;
                left.push(l);
                right.push(r);
                l = l.left;
                r = r.right;
            }
        }
        return true;
    }
}