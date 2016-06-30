public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int head = 0, tail = 0;
        Set<Integer> set = new HashSet<>();
        while(tail<nums.length)
        {
            if(tail>k){
                set.remove(nums[head]);
                head++;
            }
            if( set.contains(nums[tail]) ) return true;
            set.add(nums[tail]);
            tail++;
        }
        return false;
    }
}