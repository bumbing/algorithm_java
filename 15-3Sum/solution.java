public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1])    continue;
            int head = i+1, tail = nums.length-1;
            while(head < tail){
                int sum = nums[i] + nums[head] + nums[tail];
                if(sum == 0){
                    List<Integer> Array = new ArrayList<Integer>();
                    Array.add(nums[i]);
                    Array.add(nums[head]);
                    Array.add(nums[tail]);
                    result.add(Array);
                    while(head < tail){
                        if(nums[head] == nums[head+1])  head++;
                        else{
                            head++;
                            break;
                        }
                    }
                    
                    //两个条件可以合并
                }else if(sum < 0){
                    head++;
                }else{
                    tail--;
                }
            }
        }
        return result;
    }
}
