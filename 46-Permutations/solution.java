public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int num: nums){
            List<List<Integer>> templists = new ArrayList<List<Integer>>();
            for(List<Integer> list: result){
                for(int i=0; i<=list.size(); i++){
                    List<Integer> templist = new ArrayList<Integer>(list);
                    templist.add(i, num);
                    templists.add(templist);
                }
            }
            result = templists;
        }
        return result;
    }
}