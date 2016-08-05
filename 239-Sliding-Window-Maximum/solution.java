public class Solution {
    class Number{
        int num;
        int index;
        public Number(int num, int index){  this.num=num; this.index=index;}
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        if(nums.length==0 || k==0)  return new int[0];
        ArrayList<Number> arr = new ArrayList<>();
        arr.add(new Number(Integer.MAX_VALUE, -1));
        for(int i=0; i<nums.length; i++){
            if(i>=k && arr.get(1).index==i-k)   arr.remove(1);
            while(arr.get(arr.size()-1).num<=nums[i])   arr.remove(arr.size()-1);
            arr.add(new Number(nums[i], i));
            if(i>=k)    result[i-k]=arr.get(1).num;
        }
        return result;
    }
}