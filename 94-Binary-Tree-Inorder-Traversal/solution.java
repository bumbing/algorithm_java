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
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack();
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            result.add(temp.val);
            temp = temp.right;
            while(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
        }
        return result;
    }
}