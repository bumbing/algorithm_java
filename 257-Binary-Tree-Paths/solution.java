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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)  return new ArrayList<String>();
        return helper(root, new String());
    }
    
    public List<String> helper(TreeNode root, String s){
        List<String> result = new ArrayList<String>();
        String temp;
        if(s.equals(""))   temp = s + String.valueOf(root.val);
        else temp = s + "->" + String.valueOf(root.val);
        if(root.left==null && root.right==null){
            result.add(temp);
            return result;
        }
        if(root.left!=null)  
            result.addAll(helper(root.left, temp));
        if(root.right!=null)
            result.addAll(helper(root.right, temp));
        return result;
    }
}