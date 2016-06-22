public class Solution {
    public int rob(int[] nums){
        //Space O(1), Time O(n)
        if(nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.add(nums[0]);
        deque.add(Math.max(nums[1], nums[0]));
        for(int i=2; i<nums.length; i++){
            deque.add(Math.max(deque.peekLast(), deque.pollFirst()+nums[i]));
        }
        return deque.peekLast();
    }
    
    
    public int rob1(int[] nums) {
        if(nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[1], nums[0]);
        for(int i=2; i<nums.length; i++){
            result[i] = Math.max(result[i-1], result[i-2]+nums[i]);
        }
        return result[nums.length-1];
        //Space O(n), Time O(n);
    }
}