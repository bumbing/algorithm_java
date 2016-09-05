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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<Integer> central = new ArrayList<Integer>();
        List<List<Integer>> left = new ArrayList<List<Integer>>(), right = new ArrayList<List<Integer>>();
        if(root!=null)  helper(root, central, left, right);
        return Integrate(central, left, right);
    }
    
    public List<List<Integer>> Integrate(List<Integer> c, List<List<Integer>> left, List<List<Integer>> right){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=left.size()-1; i>=0; i--) result.add(left.get(i));
        result.add(c);
        for(List<Integer> list: right)  result.add(list);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> central, List<List<Integer>> left, List<List<Integer>> right){
        LinkedList<Integer> level = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        level.offer(0);
        nodes.offer(root);
        while(!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            int l = level.poll();
            if(l==0){
                central.add(node.val);
            }else if(l>0){
                while(l>right.size()){
                    right.add(new ArrayList<Integer>());
                }
                right.get(l-1).add(node.val);
            }else if(l<0){
                int x = l * -1;
                while(x>left.size()){
                    left.add(new ArrayList<Integer>());
                }
                left.get(x-1).add(node.val);
            }
            if(node.left!=null){
                nodes.offer(node.left);
                level.offer(l-1);
            }
            if(node.right!=null){
                nodes.offer(node.right);
                level.offer(l+1);
            }
        }
    }
}