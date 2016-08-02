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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur!=null){
            stack.push(cur);
            if(cur.val>p.val)  cur = cur.left;
            else cur = cur.right;
        }
        cur = stack.pop();
        if(cur.val!=p.val)  return cur;
        while(!stack.isEmpty()){
            TreeNode tmp = stack.peek();
            if(cur==tmp.left) return tmp;
            else    cur = stack.pop();
        }
        return null;
    }
    
    public TreeNode findMin(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}