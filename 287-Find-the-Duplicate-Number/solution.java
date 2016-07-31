public class Solution {
    public int findDuplicate(int[] nums) {
        int head=1, tail=nums.length-1, mid;
        while(head<tail){
            mid = (head+tail)/2;
            int less = 0, more = 0, equal = 0;
            for(int num: nums){
                if(num<head || num>tail)    continue;
                if(num<mid) less++;
                else if(num>mid)    more++;
                else equal++;
            }
            if(equal>1) return mid;
            if(mid-head<less)    tail = mid-1;
            else head = mid+1;
        }
        return head;
    }
}