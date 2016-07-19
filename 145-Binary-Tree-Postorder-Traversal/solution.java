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
        class AugNode{
            int val;
            TreeNode node;
            AugNode(TreeNode n){
                val = 0;
                node = n;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)    return result;
        Stack<AugNode> stack = new Stack();
        stack.push(new AugNode(root));
        while(!stack.isEmpty()){
            AugNode cur = stack.peek();
            if(cur.val==0){
                cur.val = 1;
                if(cur.node.right!=null)    stack.push(new AugNode(cur.node.right));
                if(cur.node.left!=null)     stack.push(new AugNode(cur.node.left));
            }else{
                result.add(cur.node.val);
                stack.pop();
            }
        }
        return result;
    }
}