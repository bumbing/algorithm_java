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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)    return result;
        List<TreeNode> cur=new ArrayList<>(), next=new ArrayList<>();
        cur.add(root);
        while(!cur.isEmpty()){
            List<Integer> tempList = new ArrayList<Integer>();
            for(TreeNode temp: cur){
                if(temp.left!=null) next.add(temp.left);
                if(temp.right!=null) next.add(temp.right);
                tempList.add(temp.val);
            }
            result.add(tempList);
            cur = next;
            next = new ArrayList<TreeNode>();
        }
        return result;
    }
}