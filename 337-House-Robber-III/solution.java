/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //result[0] is don't rob current one
 //result[1] is rob current one
public class Solution {
    public int rob(TreeNode root) {
        int[] result = rob_helper(root);
        return Math.max(result[0], result[1]);
    }
    
    public int[] rob_helper(TreeNode root){
        int[] result = new int[2];
        if(root != null) {
            int[] left = rob_helper(root.left);
            int[] right = rob_helper(root.right);
            result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            result[1] = root.val + left[0] + right[0];
        }
        return result;
    }
}