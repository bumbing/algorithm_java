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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        Set<TreeNode> set = new HashSet<>();
        List<Integer> result = new ArrayList<Integer>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.peek();
            if(cur == null){
                stack.pop();
                continue;
            }
            if(set.contains(cur)){
                result.add(cur.val);
                stack.pop();
            }else{
                stack.push(cur.right);
                stack.push(cur.left);
                set.add(cur);
            }
        }
        return result;
    }
}