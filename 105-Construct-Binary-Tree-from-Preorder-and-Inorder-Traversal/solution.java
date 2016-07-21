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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int head1, int tail1, int head2, int tail2){
        if(head1>tail1 || head2>tail2)  return null;
        int temp;
        for(temp = head2; temp<=tail2; temp++){
            if(inorder[temp] == preorder[head1])    break;
        }

        TreeNode node = new TreeNode(preorder[head1]);
        node.left = helper(preorder, inorder, head1+1, head1+temp-head2, head2, temp-1);
        node.right = helper(preorder, inorder, head1+temp-head2+1, tail1, temp+1, tail2);
        return node;
    }
}