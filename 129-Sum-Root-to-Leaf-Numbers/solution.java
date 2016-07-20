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
    public int sumNumbers(TreeNode root) {
        if(root==null)  return 0;
        return helper(root, 0);
    }
    
    public int helper(TreeNode root, int x){
        if(root==null)  return 0;
        x = x*10+root.val;
        if(root.left==null && root.right==null) return x;
        if(root.left==null) return helper(root.right, x);
        if(root.right==null) return helper(root.left, x);
        return helper(root.left, x) + helper(root.right, x);
        
    }
}