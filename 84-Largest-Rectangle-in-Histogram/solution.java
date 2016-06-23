public class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        if(heights.length==0)   return result;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<=heights.length; i++){
            while(!list.isEmpty()){
                int tmp = list.get(list.size()-1);
                if (heights[i] < height[tmp] || i == heights.length){
                    result = Math.max(result, height[tmp]*(i-tmp));
                    list.remove(list.size()-1);
                } else {
                    list.add(i);
                    break;
                }
            }
        }
        return result;
    }
}