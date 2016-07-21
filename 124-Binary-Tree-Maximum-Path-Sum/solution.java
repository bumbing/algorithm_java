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
    class Sum{
        Sum(int x, int y){this.max=x; this.cur=y;}
        int max;
        int cur;
    }
    
    public int maxPathSum(TreeNode root) {
        if(root==null)  return 0;
        return helper(root).max;
    }
    
    public Sum helper(TreeNode root) {
        if(root==null)  return new Sum(0,0);
        if(root.left==null && root.right==null) return new Sum(root.val, root.val);
        Sum result = new Sum(root.val, root.val);
        Sum left = new Sum(Integer.MIN_VALUE, Integer.MIN_VALUE), right = new Sum(Integer.MIN_VALUE, Integer.MIN_VALUE);
        if(root.left!=null){
            Sum temp = helper(root.left);
            left.cur = Math.max(temp.cur, 0); 
            left.max = temp.max;    
        }
        if(root.right!=null){
            Sum temp = helper(root.right);
            right.cur = Math.max(temp.cur, 0);
            right.max = temp.max;
        }
        result.cur = Math.max(left.cur, right.cur) + root.val;
        result.max = Math.max(left.max, right.max);
        result.max = Math.max(result.max, Math.max(0,left.cur)+Math.max(0,right.cur)+root.val);
        return result;
    }
    
}