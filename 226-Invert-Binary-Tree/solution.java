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
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            TreeNode tmp = nodes.poll();
            if(tmp==null)   continue;
            nodes.add(tmp.left);
            nodes.add(tmp.right);
            TreeNode tmp2 = tmp.left;
            tmp.left = tmp.right;
            tmp.right = tmp2;
        }
        return root;
    }
}