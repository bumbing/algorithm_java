public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length==0)  return result;
        int head = 0, tail = 0;
        while(tail < nums.length){
            if(tail==nums.length-1){
                result.add(printOut(nums[head], nums[tail]));
                break;
            }
            if(nums[tail+1] == nums[tail] + 1){
                tail++;
            }else{
                result.add(printOut(nums[head], nums[tail]));
                tail++;
                head = tail;
            }
        }
        return result;
    }
    
    private String printOut(int head, int tail){
        if(head == tail){
            return new String(Integer.toString(head));
        } else{
            return new String(Integer.toString(head) + "->" + Integer.toString(tail));
        }
    }
}