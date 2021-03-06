/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        return depthSumHelper(nestedList, depth);
    }
    public int depthSumHelper(List<NestedInteger> nestedList, int depth){
        int result = 0;
        for(NestedInteger list:nestedList){
            if(list.isInteger()){
                result += depth * list.getInteger();
            }else{
                List<NestedInteger> temp = list.getList();
                result += depthSumHelper(temp, depth+1);
            }
        }
        return result;
    }
}