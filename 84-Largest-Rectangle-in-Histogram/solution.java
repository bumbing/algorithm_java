public class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        if(heights.length==0)   return result;
        ArrayList<Integer> hist = new ArrayList<>();
        for(int i=0; i<heights.length; i++){
            while(!hist.isEmpty() && hist.get(hist.size()-1)>heights[i]){
                result = Math.max(result, heights[hist.get(hist.size()-1)] * (i - hist.size()==1?-1:hist.get(hist.size()-2)));
                hist.remove(hist.size()-1);
            }
            if(hist.isEmpty() || hist.get(hist.size()-1)<heights[i])   hist.add(i);
        }
        hist.add(0, -1);
        while(hist.size()>1){
            result = Math.max(result, heights[hist.get(hist.size()-1)] * (heights.length - 1 - hist.get(hist.size()-2)));
        }
        return result;
    }
}