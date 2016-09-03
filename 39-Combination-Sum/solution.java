public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        for(int i=0; i<candidates.length; i++){
            List<Integer> list = new ArrayList<Integer>();
            list.add(candidates[i]);
            dfs(target-candidates[i], list, i, result, candidates);
        }
        return result;
    }
    
    public void dfs(int target, list<Integer> list, int index, List<List<Integer> result, int[] c){
        if(target<0)    return;
        if(target==0)   result.add(list);
        for(int i=index; i<c.length; i++){
            list.add(c[i]);
            dfs(target-c[i], list, i, result, candidates);
            list.remove(list.size()-1);
        }
        return;
    }
}