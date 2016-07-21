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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int head1, int tail1, int head2, int tail2){
        if(head1>tail1 || head2>tail2)  return null;
        int temp;
        for(temp = head1; temp<=tail1; temp++){
            if(inorder[temp] == postorder[tail2])    break;
        }

        TreeNode node = new TreeNode(postorder[tail2]);
        node.left = helper(inorder, postorder, head1, temp-1, head2, head2+temp-head1-1);
        node.right = helper(inorder, postorder, temp+1, tail1, head2+temp-head1, tail2-1);
        return node;
    }
}