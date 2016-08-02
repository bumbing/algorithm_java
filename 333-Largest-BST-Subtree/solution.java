/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//result 0:largest, 1:min, 2:max, 3,valid
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        int[] result = subtreeHelper(root);
        return result[0];
    }
    public int[] subtreeHelper(TreeNode root){
        int[] result = new int[4], left=new int[4], right=new int[4];
        result[3] = 1;
        if(root==null)  return result;
        if(root.left!=null){ 
            left=subtreeHelper(root.left);
            if(left[3]==0 || left[2]>root.val)  result[3]=0;
        }
        if(root.right!=null){
            right=subtreeHelper(root.right);
            if(right[3]==0 || right[1]<root.val)    result[3]=0;
        }
        if(result[3]==1){
            result[1] = (root.left==null)?root.val:left[1];
            result[2] = (root.right==null)?root.val:right[2];
            result[0] = 1 + ((root.left==null)?0:left[0]) + ((root.right==null)?0:right[0]);
        }else{
            result[0] = Math.max(left[0], right[0]);
        }   
        return result;
    }
    
}