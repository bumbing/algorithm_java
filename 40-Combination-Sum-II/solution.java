public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        helper(list, candidates, target, 0);
        return result;
    }
    public void helper(ArrayList<Integer> list, int[] candidates, int target, int index){
        if(target == 0) result.add(list);
        else{
            for(int i=index; i<candidates.length; i++){
                if(candidates[i]<=target){
                    list.add(candidates[i]);
                    helper(list, candidates, target[candidates[i], i+1);
                }else{
                    break;
                }
                while(i<candidates.length-1 && candidates[i]==candidates[i+1]) i++;
            }
        }
    }
}