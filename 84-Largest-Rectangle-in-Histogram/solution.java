public class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        if(heights.length==0)   return result;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<=heights.length; i++){
            while(!list.isEmpty()){
                int tmp = list.get(list.size()-1);
                if (i == heights.length || heights[i] < heights[tmp]){
                    result = Math.max(result, heights[tmp]*(i-tmp));
                    list.remove(list.size()-1);
                }
            }
            list.add(i);
        }
        return result;
    }
}