public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationHelper(candidates, target, 0);
    }
    public List<List<Integer>> combinationHelper(int[] candidates, int target, int index){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=index; i<candidates.length; i++){
            int num = candidates[i];
            List<List<Integer>> temp;
            if(target>num){
                temp = combinationHelper(candidates, target-num, i);
                for(List<Integer> lists: temp){
                    lists.add(num);
                    result.add(lists);
                }
            }else if(target==num){
                List<Integer> list = new ArrayList<Integer>();
                list.add(target);
                result.add(list);
            }
        }
        return result;
    }
}
