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
    public boolean isValidBST(TreeNode root) {
        int number = Integer.MIN_VALUE;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack();
        boolean first = false;
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }   
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.val <= number && first)  return false;
            first = true;
            number = temp.val;
            temp = temp.right;
            while(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
        }

        return true;
    }
    
}