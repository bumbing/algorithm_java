public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] length = new int[nums.length];
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length; i++)    list.add(new ArrayList<Integer>());
        int max = 0;
        for(int i=nums.length-1; i>=0; i--){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            int append_max=i;
            int append_length=1;
            //list.set(i, new ArrayList<Integer>());
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]%nums[i]!=0)  continue;
                if(append_length<1+list.get(j).size()){
                    append_length = 1+list.get(j).size();
                    append_max = j;
                }
            }
            temp.addAll(list.get(append_max));
            List<Integer> cur = new ArrayList<Integer>(temp);
            list.set(i, cur);
            length[i] = append_length;
            if(append_length>max){
                max = append_length;
                result = cur;
            }
        }
        return result;
    }
}