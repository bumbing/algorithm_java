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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0)    return null;
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int head, int tail){
        if(head > tail) return null;
        int mid = (head+tail)/2;
        TreeNode result = new TreeNode(nums[mid]);
        result.left = helper(nums, head, mid-1);
        result.right = helper(nums, mid+1, tail);
        return result;
    }
}