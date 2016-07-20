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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)  return result;
        result.add(root.val);
        List<Integer> left = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        while(!left.isEmpty() || !right.isEmpty()){
            if(!right.isEmpty() && !left.isEmpty()){
                result.add(right.get(0));
                right.remove(0);
                left.remove(0);
            }else if(!right.isEmpty()){
                result.add(right.get(0));
                right.remove(0);
            }else if(!left.isEmpty()){
                result.add(left.get(0));
                left.remove(0);
            }
        }
        return result;
    }
}