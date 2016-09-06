public class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Integer> nums = new Stack();
        for(int i=0; i<heights.length; i++){
            result = Math.max(result, addLast(nums, i, heights[i], heights));
        }
        result = Math.max(result, addLast(nums, heights.length, 0, heights));
        return result;
    }
    
    private int addLast(Stack<Integer> nums, int index, int height, int[] heights){
        int result = 0;
        while(true){
            if(nums.isEmpty())  break;
            int tmp = heights[nums.get(nums.size()-1)];
            if(tmp < height) break;
            if(tmp == height){
                nums.remove(nums.size()-1);
                break;
            }
            //calculate and remove the last one
            int product = index;
            product -= (nums.size()==1)?0:nums.get(nums.size()-2)+1; 
            result = Math.max(result, tmp * product);
            nums.remove(nums.size()-1);
        }
        nums.add(index);
        return result;
    }
}