public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] biggest = new int[nums.length];
        Arrays.fill(biggest,Integer.MAX_VALUE);
        for(int num: nums){
            int index = binarySearch(biggest, num);
            biggest[index] = num;
        }
        int count = 0;
        for(int num: nums){
            if(num==Integer.MAX_VALUE)  break;
            count++;
        }
        return count;
    }
    
    public int binarySearch(int[] biggest, int num){
        int head = 0, tail = biggest.length-1;
        while(head+1<tail){
            int mid = head + (tail-head)/2;
            if(biggest[mid]>=num)   tail = mid;
            else    head = mid;
        }
        if(biggest[head]>=num)   return head;
        if(biggest[tail]>=num)   return tail;
        return -1;
    }
}