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
    class Count{
        TreeNode node;
        int count;
        public Count(TreeNode cur, int num){this.node=cur; this.count=num;}
    }
    public int longestConsecutive(TreeNode root) {
        if(root==null)  return 0;
        Stack<Count> stack = new Stack();
        stack.push(new Count(root, 1));
        int result = 1;
        while(!stack.isEmpty()){
            Count temp = stack.pop();
            int count;
            if(temp.node.left!=null){
                count = (temp.node.val+1==temp.node.left.val)?temp.count+1:1;
                stack.push(new Count(temp.node.left, count));
            }
            if(temp.node.right!=null){
                count = (temp.node.val+1==temp.node.right.val)?temp.count+1:1;
                stack.push(new Count(temp.node.right, count));
            }
            result = Math.max(result, temp.count);
        }
        return result;
    }
}