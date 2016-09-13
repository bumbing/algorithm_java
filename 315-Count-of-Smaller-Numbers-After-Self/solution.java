public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] rank = Arrays.copyOf(nums, nums.length), tree = new int[nums.length+1];
        Arrays.sort(rank);
        Map<Integer, Integer> map = new HashMap<>();
        int pre = Integer.MIN_VALUE, smaller = 0;
        for(int tmp: rank){
            if(tmp != pre){
                map.put(tmp, smaller);
                pre = tmp;
            }
            smaller++;
        }
        for(int i=nums.length-1; i>=0; i--){
            int r = map.get(nums[i]);
            //result.add(r>0?req(tree, r):0, 0);
            //update(tree, r+1);
        }
        return result;
        
    }
    
    public void update(int[] tree, int index){
        while(index<tree.length){
            tree[index] = tree[index]+1;
            index += index & (index-1);
        }
    }
    
    public int req(int[] tree, int index){
        int result = 0;
        while(index>0){
            result += tree[index];
            index -= index & (index-1);
        }
        return result;
    }
    
}