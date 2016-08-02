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
    class Result{
        int count;
        boolean subtreeValid;
        public Result(int count, boolean valid){this.count=count; this.subtreeValid=valid;}
    }
    public int countUnivalSubtrees(TreeNode root) {
        return helper(root).count;
    }
    public Result helper(TreeNode root){
        Result result = new Result(0, true);
        if(root==null)  return result;
        if(root.left!=null){
            Result left = helper(root.left);
            result.count += left.count;
            result.subtreeValid &= left.subtreeValid;
        }
        if(root.right!=null){
            Result right = helper(root.right);
            result.count += right.count;
            result.subtreeValid &= right.subtreeValid;
        }
        if(result.subtreeValid)   result.count++;
        return result;
    }
}