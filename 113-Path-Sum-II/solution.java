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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if(root == null)    return result;
        if(root.left==null && root.right==null){
            if(root.val==sum){
                temp.add(root.val);
                result.add(temp);
            }
            return result;
        }
        
        if(root.left!=null){
            result.addAll(pathSum(root.left, sum-root.val));
        }
        if(root.right!=null){
            result.addAll(pathSum(root.right, sum-root.val));
        }
        for(List<Integer> list: result){
            list.add(0, root.val);
        }
        return result;
    }
}