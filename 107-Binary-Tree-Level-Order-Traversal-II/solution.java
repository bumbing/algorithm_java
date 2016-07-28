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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)  return result;
        int cur = 1, next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<Integer>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            values.add(temp.val);
            cur--;
            if(temp.left!=null){
                next++;
                queue.add(temp.left);
            }
            if(temp.right!=null){
                next++;
                queue.add(temp.right);
            }
            if(cur==0){
                cur = next;
                next = 0;
                result.add(0, values);
                values = new ArrayList<Integer>();
            }
            
        }
        return result;
        
    }
}