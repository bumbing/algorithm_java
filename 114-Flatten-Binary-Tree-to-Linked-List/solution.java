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
    public TreeNode flatten(TreeNode root) {
        if(root==null)  return root;
        if(root.left==null && root.right==null) return root;
        if(root.left==null) return flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = flatten(root.right);
        if(temp==null)  return cur;
        cur.left = null;
        cur.right = temp;
        return flatten(temp);
    }
    
    
}