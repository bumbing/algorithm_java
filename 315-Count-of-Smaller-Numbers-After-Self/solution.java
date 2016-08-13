public class Solution {
    class Node{
        int val;
        int rank=0;
        Node left, right;
        public Node(int x){ this.val = x;}
    }
    public List<Integer> countSmaller(int[] nums) {
        //BST
        Node root = null;
        List<Integer> result = new ArrayList<>();
        if(nums==null || nums.length==0)    return result;
        for(int i=nums.length-1; i>=0; i--){
            if(i==nums.length-1){
                root = new Node(nums[i]);
                result.add(0, 0);
            }else
            result.add(0, insert(root, nums[i]));
        }
        return result;
    }
    
    public int insert(Node root, int val){
        int smaller = 0;
        Node temp;
        while(root!=null){
            temp = root;
            if(root.val>=val){
                root.rank++;
                root = root.left;
            }   
            else{
                smaller += root.rank+1;
                root = root.right;
            }
        }
        if(temp.val>=val) temp.left = new Node(val);
        else temp.right = new Node(val);
        return smaller;
    }
}