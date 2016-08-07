public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int num: candidates){
            List<List<Integer>> temp;
            if(target>num){
                temp = combinationSum(candidates, target-num);
                for(List<Integer> lists: temp){
                    lists.add(num);
                    result.add(lists);
                }
            }else if(target==num){
                result.add(new ArrayList<Integer>().add(target));
            }
        }
        return result;
    }
}