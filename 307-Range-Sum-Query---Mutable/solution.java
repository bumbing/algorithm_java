public class NumArray {

    class TreeNode{
        int head, tail, val;
        TreeNode left, right;
        public TreeNode(int head, int tail){    this.head=head; this.tail=tail;}
    }
    
    int[] nums;
    TreeNode root;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        for(int i=0; i<nums.length; i++)    this.nums[i] = nums[i];
        this.root = buildTree(nums, 0, nums.length-1);
    }
    
    public TreeNode buildTree(int[] nums, int head, int tail){
        int mid = (head+tail)/2;
        TreeNode root = new TreeNode(head, tail);
        if(head==tail)  root.val = this.nums[head];
        else{
            root.left = buildTree(nums, head, mid);
            root.right = buildTree(nums, mid+1, tail);
            root.val = root.left.val + root.right.val;
        }
        return root;
    }

    public void update(int i, int val) {
        int diff = this.nums[i] - val;
        TreeNode cur = this.root;
        while(cur!=null){
            cur.val -= diff;
            if(i<=(cur.head+cur.tail)/2) cur = cur.left;
            else cur = cur.right;
        }
    }

    public int sumRange(int i, int j) {
        return sumHelper(i, j, this.root);
    }
    
    public int sumHelper(int i, int j, TreeNode root){
        if(root.head==i && root.tail==j)    
            return root.val;
        int result = 0, mid = (root.head+root.tail)/2;
        if(i<=mid+1){
            result += sumHelper(i, mid, root.left);
        }
        if(j>=mid){
            result += sumHelper(mid+1, j, root.right);
        }
        return result;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);