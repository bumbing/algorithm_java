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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.empty()){
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return result;
    }
}