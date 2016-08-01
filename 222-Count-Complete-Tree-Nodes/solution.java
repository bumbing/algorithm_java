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
    public int countNodes(TreeNode root) {
        int l= 0, r=0;
        TreeNode left = root, right=root;
        while(left!=null){
            left = left.left;
            l++;
        }
        while(right!=null){
            right = right.right;
            r++;
        }
        if(l==r)    return (1 << l) - 1;
        else    return 1+countNodes(root.left)+countNodes(root.right);
    }
}