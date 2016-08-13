public class Solution {
    class SegmentTreeNode {
        int start, end;
        int num;
        SegmentTreeNode ltree, rtree;
        public SegmentTreeNode(int s, int e) {
            start = s;
            end = e;
            num = 0;
        }
    }
    public SegmentTreeNode buildTree(int left, int right) {
        SegmentTreeNode root = new SegmentTreeNode(left, right);
        if (left != right) {
            int mid = (left + right)/2;
            root.ltree = buildTree(left, mid);
            root.rtree = buildTree(mid+1, right);
        }
        return root;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums==null || nums.length == 0)  return result;
        SegmentTreeNode root = buildTree(0, nums.length-1);
        int[] sortList = nums.clone();
        Arrays.sort(sortList);
        for(int i=nums.length-1; i>=0; i--){
            int index = Arrays.binarySearch(sortList, nums[i]);
            result.add(0, query(root, index));
        }
        return result;
    }
    
    public int query(SegmentTreeNode root, int index){
        int result = 0;
        while(root!=null){
            if(index<=(root.start+root.end)/2){
                root.num = root.num + 1;
                root = root.ltree;
            }else{
                result += root.num;
                root = root.rtree;
            }
        }
        return result;
    }
    
}