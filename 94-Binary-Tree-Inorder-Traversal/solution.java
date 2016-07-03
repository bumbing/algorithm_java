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
    //Hashmap
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        if(root == null)    return result;
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.peek();
            if(set.contains(temp)){
                result.add(temp.val);
                stack.pop();
                if(temp.right != null)  stack.push(temp.right);
            }else{
                set.add(temp);
                if(temp.left != null)   stack.push(temp.left);
            }
        }
        return result;
    }
}