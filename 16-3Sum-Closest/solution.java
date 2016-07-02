public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1])  continue;
            int head = i+1, tail = nums.length-1;
            while(head < tail){
                int sum = nums[i] + nums[head] + nums[tail];
                if(sum==target){
                    return target;
                }else if(sum < target){
                    head++;
                }else{
                    tail--;
                }
                if(Math.abs(target-result) > Math.abs(target-sum))  result = sum;
            }
        }
        return result;
    }
}