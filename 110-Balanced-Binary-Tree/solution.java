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
    public boolean isBalanced(TreeNode root) {
        if(root==null)  return true;
        if(!isBalanced(root.left) || !isBalanced(root.right))   return false;
        int left = (root.left!=null)?root.left.val:0;
        int right = (root.right!=null)?root.right.val:0;
        root.val = Math.max(left, right) + 1;
        return Math.abs(left-right) <= 1;
    }
}