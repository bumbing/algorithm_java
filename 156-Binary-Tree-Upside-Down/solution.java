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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null)  return root;
        Stack<TreeNode> stack = new Stack();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        TreeNode cur;
        root=stack.peek();
        while(!stack.isEmpty()){
            cur=stack.pop();
            if(stack.isEmpty()) break;
            cur.left = stack.peek().right;
            cur.right = stack.peek();
        }
        return root;
        
    }
}